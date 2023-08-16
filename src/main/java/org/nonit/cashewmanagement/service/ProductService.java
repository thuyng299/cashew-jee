package org.nonit.cashewmanagement.service;

import org.nonit.cashewmanagement.dao.ProductDAO;
import org.nonit.cashewmanagement.mapper.ProductMapper;

import javax.inject.Inject;

public class ProductService {

    @Inject
    private ProductDAO productDAO;

    @Inject
    private ProductMapper productMapper;
}
