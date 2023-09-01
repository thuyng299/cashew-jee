package org.nonit.cashewmanagement.dao;

import org.nonit.cashewmanagement.entity.SupplierEntity;
import org.nonit.cashewmanagement.utils.dao.BaseDAO;

import javax.ejb.Stateless;

@Stateless
public class SupplierDAO extends BaseDAO<SupplierEntity> {

    public SupplierDAO(){
        super(SupplierEntity.class);
    }
}
