package com.jambler.bfm.services;

import com.jambler.bfm.domain.Customer;
import com.jambler.bfm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Transactional
@Service
public class InitDbService {

    @Autowired
    private CustomerRepository customerRepository;
/*    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ManagerRepository managerRepository; */

    @PostConstruct
    public void init() {
        Customer customer = new Customer("test1");
        Customer customer2 = new Customer("test2");
        Customer customer3 = new Customer("test3");
        customerRepository.save(customer);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
    }

}
