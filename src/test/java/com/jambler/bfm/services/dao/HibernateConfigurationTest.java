package com.jambler.bfm.services.dao;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-database/database.xml")
public class HibernateConfigurationTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void testHibernateConfiguration() {
        // Spring IOC container instantiated and prepared sessionFactory
        assertNotNull(sessionFactory);
    }

}