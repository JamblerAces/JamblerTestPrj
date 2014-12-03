package com.jambler.bfm.services.impl;

import com.jambler.bfm.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.jambler.bfm.services.CustomerService;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class CustomerServiceImplTest {

    @Autowired
    private CustomerService service;

    @Test
    @Transactional
    public void testFindByName() throws Exception {
        service.add(new Customer("testCustomer"));
        Customer customer = service.findByName("testCustomer");
        assertNotNull(customer);
    }

}