package services.dao.impl;

import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import services.dao.CustomerDao;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CustomerJdbcDAO implements CustomerDao {

    @Autowired
    private DataSource dataSource;

    @Override
    public void add(Customer entity) {

    }

    @Override
    public void update(Customer entity) {

    }

    @Override
    public void remove(Customer entity) {

    }

    @Override
    public Customer find(Long key) {
        return null;
    }

    @Override
    public List<Customer> list() {
        return null;
    }
}
