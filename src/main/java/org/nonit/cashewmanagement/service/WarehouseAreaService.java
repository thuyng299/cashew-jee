package org.nonit.cashewmanagement.service;

import org.nonit.cashewmanagement.dao.WarehouseAreaDAO;
import org.nonit.cashewmanagement.mapper.WarehouseAreaMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
@Stateless
public class WarehouseAreaService {

    @Inject
    private WarehouseAreaDAO warehouseAreaDAO;

    @Inject
    private WarehouseAreaMapper warehouseAreaMapper;
}
