package org.nonit.cashewmanagement.service;

import org.nonit.cashewmanagement.dao.CustomerDAO;
import org.nonit.cashewmanagement.mapper.CustomerMapper;

import javax.inject.Inject;

public class CustomerService {

    @Inject
    private CustomerDAO customerDAO;

    @Inject
    private CustomerMapper customerMapper;
}
