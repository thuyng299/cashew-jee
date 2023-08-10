package org.nonit.dao;

import org.nonit.entity.RegionEntity;
import org.nonit.utils.dao.BaseDAO;

import javax.ejb.Stateless;

@Stateless
public class RegionDAO extends BaseDAO<RegionEntity> {

    public RegionDAO() {
        super(RegionEntity.class);
    }

}
