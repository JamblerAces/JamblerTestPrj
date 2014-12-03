package com.jambler.bfm.services.dao;

import com.jambler.bfm.domain.Customer;

public interface CustomerDao extends GenericDao<Customer> {

    public Customer findByName(String name);
}
