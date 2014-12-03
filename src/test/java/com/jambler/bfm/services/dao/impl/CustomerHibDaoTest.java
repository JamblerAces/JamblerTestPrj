package com.jambler.bfm.services.dao.impl;

import com.jambler.bfm.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.jambler.bfm.services.dao.CustomerDao;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class CustomerHibDaoTest {

    @Autowired
    CustomerDao dao;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    @Transactional
    public void testFindByName() throws Exception {
        dao.save(new Customer("testCustomer"));
        Customer customer = dao.findByName("testCustomer");
        assertNotNull(customer);
    }

    @Test
    @Transactional
    public void testFindByNameAgain() throws Exception {
        dao.save(new Customer("testCustomer"));
        List<Customer> customers = dao.findAll();
        assertEquals(1, customers.size());
    }
}