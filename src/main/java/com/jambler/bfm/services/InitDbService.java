package com.jambler.bfm.services;

import com.jambler.bfm.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitDbService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ManagerRepository managerRepository;

}
