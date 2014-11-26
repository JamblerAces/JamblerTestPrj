package services.impl;

import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.AbstractService;
import services.CustomerService;
import services.dao.GenericDao;
import services.dao.impl.CustomerJdbcDAO;

@Service
public class CustomerServiceImpl extends AbstractService<Customer> implements CustomerService {

    @Autowired
    private CustomerJdbcDAO dao;

    @Override
    protected GenericDao<Customer, Long> getDao() {
        return dao;
    }
}
