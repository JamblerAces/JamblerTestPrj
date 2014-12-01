package services.dao;

import domain.Customer;

public interface CustomerDao extends GenericDao<Customer> {

    public Customer findByName(String name);
}
