package org.nonit.cashewmanagement.dao;

import org.nonit.cashewmanagement.entity.SupplierEntity;
import org.nonit.cashewmanagement.entity.WarehouseAreaEntity;
import org.nonit.cashewmanagement.utils.dao.BaseDAO;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Stateless
public class WarehouseAreaDAO extends BaseDAO<WarehouseAreaEntity> {

    public WarehouseAreaDAO(){
        super(WarehouseAreaEntity.class);
    }

    public Optional<WarehouseAreaEntity> findByName(String name){
        List<WarehouseAreaEntity> supplierEntityList = em.createQuery("SELECT DISTINCT w FROM WarehouseAreaEntity w " +
                        "WHERE LOWER(trim(both from w.name)) LIKE LOWER(trim(both from :name))", WarehouseAreaEntity.class)
                .setParameter("name", name)
                .getResultList();
        return supplierEntityList.isEmpty() ? Optional.empty() : Optional.of(supplierEntityList.get(0));
    }
}
