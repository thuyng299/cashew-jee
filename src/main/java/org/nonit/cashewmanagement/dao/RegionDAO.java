package org.nonit.cashewmanagement.dao;

import org.nonit.cashewmanagement.entity.RegionEntity;
import org.nonit.cashewmanagement.utils.dao.BaseDAO;

import javax.ejb.Stateless;

@Stateless
public class RegionDAO extends BaseDAO<RegionEntity> {

    public RegionDAO() {
        super(RegionEntity.class);
    }

}
