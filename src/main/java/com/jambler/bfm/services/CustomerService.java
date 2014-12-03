package com.jambler.bfm.services;

import com.jambler.bfm.domain.Customer;

public interface CustomerService extends GenericService<Customer> {
    Customer findByName(String testCustomer);
}
