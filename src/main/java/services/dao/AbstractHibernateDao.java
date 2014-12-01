package services.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public abstract class AbstractHibernateDao<E> implements GenericDao<E> {

    private SessionFactory sessionFactory;
    protected Class<? extends E> entityType;

    @SuppressWarnings("unchecked")
    public AbstractHibernateDao() {
        entityType = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(E entity) {
        currentSession().save(entity);
    }

    @Override
    public void remove(E entity) {
        currentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E find(Long key) {
        return (E) currentSession().get(entityType, key);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<E> findAll() {
        return currentSession().createCriteria(entityType).list();
    }
}
