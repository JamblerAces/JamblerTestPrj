package services.dao.impl;

import domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import services.dao.CustomerDao;

import java.util.List;

public class CustomerHibDao implements CustomerDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Customer customer) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(customer);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Customer> findAll() {
        Session session = this.sessionFactory.openSession();
        List<Customer> personList = session.createQuery("from customer").list();
        session.close();
        return personList;
    }

    @Override
    public void remove(Customer entity) {
        // TODO body of implemented method
    }

    @Override
    public Customer find(Long key) {
        return null;  // TODO body of implemented method
    }
}
