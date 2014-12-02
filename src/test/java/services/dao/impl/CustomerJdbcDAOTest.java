package services.dao.impl;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import domain.Customer;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import services.dao.CustomerDao;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class CustomerJdbcDAOTest {

    @Autowired
    CustomerDao dao;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public void testCreate() throws Exception {
        Customer newCus = new Customer("testNew");
        dao.save(newCus);
        /*testing commit message
        * and fgfg gfgh ggh gh gh fdfg fg dgf*/
        List<Customer> customers = dao.findAll();
        Collection<Customer> customersFiltered = Collections2.filter(customers, new CustomerPredicateByName());
        assertTrue(customersFiltered.size() > 0);
    }

    @Test
    @Ignore
    public void testUpdate() throws Exception {
        Customer newCus = new Customer("testNew");
        dao.save(newCus);
        Customer customer = dao.findByName("testNew");
        assertEquals("testNew", customer.getName());
    }

    class CustomerPredicateByName implements Predicate<Customer> {
        @Override
        public boolean apply(Customer customer) {
            return "testNew".equals(customer.getName());
        }
    }
}