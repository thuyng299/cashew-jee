package org.nonit.cashewmanagement.dao;

import org.nonit.cashewmanagement.entity.CountryEntity;
import org.nonit.cashewmanagement.utils.dao.BaseDAO;

public class CountryDAO extends BaseDAO<CountryEntity> {

    public CountryDAO(){
        super(CountryEntity.class);
    }
}
