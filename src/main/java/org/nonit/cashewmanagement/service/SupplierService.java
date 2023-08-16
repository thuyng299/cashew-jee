package org.nonit.cashewmanagement.service;

import org.nonit.cashewmanagement.dao.SupplierDAO;
import org.nonit.cashewmanagement.mapper.SupplierMapper;

import javax.inject.Inject;

public class SupplierService {

    @Inject
    private SupplierDAO supplierDAO;

    @Inject
    private SupplierMapper supplierMapper;
}
