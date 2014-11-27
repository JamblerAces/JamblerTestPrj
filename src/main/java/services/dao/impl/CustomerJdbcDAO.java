package services.dao.impl;

import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import services.dao.AbstractJdbcTemplateDao;
import services.dao.CustomerDao;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service(value = "CustomerDao")
public class CustomerJdbcDAO extends AbstractJdbcTemplateDao<Customer, Long> implements CustomerDao {

    private static final CustomerRowMapper rowMapper = new CustomerRowMapper();

    private static enum SQL_QUERY {
        create("INSERT INTO customer (name) VALUES (?)"),
        update("UPDATE customer SET name = ? WHERE id = ?"),
        remove("DELETE FROM customer  WHERE id = ?"),
        findById("SELECT * FROM customer WHERE id = ?"),
        findAll("SELECT * FROM customer");

        private String query;

        SQL_QUERY(String query) {
            this.query = query;
        }

        public String getQuery() {
            return query;
        }
    }

    @Autowired
    public CustomerJdbcDAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void create(Customer entity) {
        getJdbcTemplateObject().update(SQL_QUERY.create.getQuery(), entity.getName());
    }

    @Override
    public void update(Customer entity) {
        getJdbcTemplateObject().update(SQL_QUERY.update.getQuery(), entity.getName(), entity.getId());
    }

    @Override
    public void remove(Customer entity) {
        getJdbcTemplateObject().update(SQL_QUERY.remove.getQuery(), entity.getId());
    }

    @Override
    public Customer find(Long key) {
        return getJdbcTemplateObject().queryForObject(SQL_QUERY.findById.getQuery(), rowMapper, key);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        List<Map<String, Object>> rows = getJdbcTemplateObject().queryForList(SQL_QUERY.findAll.getQuery());
        for (Map row : rows) {
            Customer customer = new Customer();
            customer.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
            customer.setName((String) row.get("NAME"));
            customers.add(customer);
        }

        return customers;
    }

    @SuppressWarnings("rawtypes")
    private static class CustomerRowMapper implements RowMapper<Customer> {
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setId(rs.getInt("ID"));
            customer.setName(rs.getString("NAME"));
            return customer;
        }
    }
}
