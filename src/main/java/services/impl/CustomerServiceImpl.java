package services.impl;

import domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.AbstractService;
import services.CustomerService;
import services.dao.CustomerDao;
import services.dao.GenericDao;

@Service
public class CustomerServiceImpl extends AbstractService<Customer> implements CustomerService {

    static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Autowired
    private CustomerDao dao;

    @Autowired
    public void setDao(CustomerDao dao) {
        this.dao = dao;
    }

    @Override
    protected GenericDao<Customer> getDao() {
        return dao;
    }

    @Override
    public Customer findByName(String customerName) {
        logger.debug("Looking for customer with name = " + customerName);
        return dao.findByName(customerName);
    }
}
