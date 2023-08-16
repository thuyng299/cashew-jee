package org.nonit.cashewmanagement.dao;

import org.nonit.cashewmanagement.entity.ProductEntity;
import org.nonit.cashewmanagement.utils.dao.BaseDAO;

public class ProductDAO extends BaseDAO<ProductEntity> {

    public ProductDAO(){
        super(ProductEntity.class);
    }
}
