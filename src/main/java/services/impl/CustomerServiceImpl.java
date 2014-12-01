package services.impl;

import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.AbstractService;
import services.CustomerService;
import services.dao.CustomerDao;
import services.dao.GenericDao;

@Service
public class CustomerServiceImpl extends AbstractService<Customer> implements CustomerService {


    private CustomerDao dao;

    @Autowired
    public void setDao(CustomerDao dao) {
        this.dao = dao;
    }

    @Override
    protected GenericDao<Customer> getDao() {
        return dao;
    }
}
