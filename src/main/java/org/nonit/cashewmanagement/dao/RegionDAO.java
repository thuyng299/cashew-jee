package org.nonit.cashewmanagement.dao;

import org.nonit.cashewmanagement.entity.RegionEntity;
import org.nonit.cashewmanagement.utils.dao.BaseDAO;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Stateless
public class RegionDAO extends BaseDAO<RegionEntity> {

    public RegionDAO() {
        super(RegionEntity.class);
    }

    public Optional<RegionEntity> findByName(String name){
        List<RegionEntity> regionEntityList = em.createQuery("SELECT DISTINCT r FROM RegionEntity r " +
                "WHERE LOWER(trim(both from r.name)) LIKE LOWER(trim(both from :name))", RegionEntity.class)
                .setParameter("name", name)
                .getResultList();
        return regionEntityList.isEmpty() ? Optional.empty() : Optional.of(regionEntityList.get(0));
    }

}
