package services.dao.impl;

import domain.Customer;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import services.dao.AbstractHibernateDao;
import services.dao.CustomerDao;

import java.util.List;

@Repository
public class CustomerHibDao extends AbstractHibernateDao<Customer> implements CustomerDao {

    @Override
    @SuppressWarnings("unchecked")
    public Customer findByName(String name) {
        List<Customer> customers = currentSession().createCriteria(Customer.class).add(Restrictions.like("name", name)).list();
        if (customers.isEmpty()) return null;
        return customers.get(0);
    }
}
