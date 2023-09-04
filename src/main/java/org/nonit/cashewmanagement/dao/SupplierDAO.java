package org.nonit.cashewmanagement.dao;

import org.nonit.cashewmanagement.entity.StatusEnum;
import org.nonit.cashewmanagement.entity.SupplierEntity;
import org.nonit.cashewmanagement.utils.dao.BaseDAO;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Stateless
public class SupplierDAO extends BaseDAO<SupplierEntity> {

    public SupplierDAO(){
        super(SupplierEntity.class);
    }

    public List<SupplierEntity> findByStatus(StatusEnum status){
       return em.createQuery("SELECT s FROM SupplierEntity s " +
                "WHERE s.status LIKE :status ORDER BY s.name", SupplierEntity.class)
                .setParameter("status", status)
                .getResultList();
    }

    public Optional<SupplierEntity> findByName(String name){
        List<SupplierEntity> supplierEntityList = em.createQuery("SELECT DISTINCT s FROM SupplierEntity s " +
                "WHERE LOWER(trim(both from s.name)) LIKE LOWER(trim(both from :name))", SupplierEntity.class)
                .setParameter("name", name)
                .getResultList();
        return supplierEntityList.isEmpty() ? Optional.empty() : Optional.of(supplierEntityList.get(0));
    }

}
