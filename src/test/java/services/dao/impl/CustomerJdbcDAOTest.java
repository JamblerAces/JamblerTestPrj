package services.dao.impl;

import domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import services.dao.CustomerDao;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class CustomerJdbcDAOTest {

    @Autowired
    CustomerDao dao;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testCreate() throws Exception {
        Customer newCus = new Customer("testNew");
        dao.create(newCus);
        Customer cus = dao.find(2l);
        /*test commit f dfg fdg  */
        assertEquals("testNew", cus.getName());
    }
}