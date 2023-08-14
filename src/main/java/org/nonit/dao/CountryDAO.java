package org.nonit.dao;

import org.nonit.entity.CountryEntity;
import org.nonit.utils.dao.BaseDAO;

public class CountryDAO extends BaseDAO<CountryEntity> {

    public CountryDAO(){
        super(CountryEntity.class);
    }
}
