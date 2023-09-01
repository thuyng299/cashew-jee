package org.nonit.cashewmanagement.dao;

import org.nonit.cashewmanagement.entity.WarehouseAreaEntity;
import org.nonit.cashewmanagement.utils.dao.BaseDAO;

import javax.ejb.Stateless;

@Stateless
public class WarehouseAreaDAO extends BaseDAO<WarehouseAreaEntity> {

    public WarehouseAreaDAO(){
        super(WarehouseAreaEntity.class);
    }
}
