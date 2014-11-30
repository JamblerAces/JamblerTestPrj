package services.dao;

import domain.Customer;

public interface CustomerDao extends GenericDao<Customer, Long> {

    public Customer findByName(String name);
}
