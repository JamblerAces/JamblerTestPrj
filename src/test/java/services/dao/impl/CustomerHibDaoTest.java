package services.dao.impl;

import domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import services.dao.CustomerDao;

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
}