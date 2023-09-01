package org.nonit.cashewmanagement.service;

import org.nonit.cashewmanagement.dao.CustomerDAO;
import org.nonit.cashewmanagement.mapper.CustomerMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CustomerService {

    @Inject
    private CustomerDAO customerDAO;

    @Inject
    private CustomerMapper customerMapper;
}
