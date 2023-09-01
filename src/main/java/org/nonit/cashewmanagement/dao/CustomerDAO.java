package org.nonit.cashewmanagement.dao;

import org.nonit.cashewmanagement.entity.CustomerEntity;
import org.nonit.cashewmanagement.utils.dao.BaseDAO;

import javax.ejb.Stateless;

@Stateless
public class CustomerDAO extends BaseDAO<CustomerEntity> {

    public CustomerDAO(){
        super(CustomerEntity.class);
    }
}
