package org.nonit.cashewmanagement.dao;

import org.nonit.cashewmanagement.entity.CustomerEntity;
import org.nonit.cashewmanagement.entity.StatusEnum;
import org.nonit.cashewmanagement.entity.SupplierEntity;
import org.nonit.cashewmanagement.utils.dao.BaseDAO;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Stateless
public class CustomerDAO extends BaseDAO<CustomerEntity> {

    public CustomerDAO(){
        super(CustomerEntity.class);
    }

    public List<CustomerEntity> findByStatus(StatusEnum status){
        return em.createQuery("SELECT c FROM CustomerEntity c " +
                        "WHERE c.status LIKE :status ORDER BY c.name", CustomerEntity.class)
                .setParameter("status", status)
                .getResultList();
    }

    public Optional<CustomerEntity> findByName(String name){
        List<CustomerEntity> customerEntityList = em.createQuery("SELECT DISTINCT c FROM CustomerEntity c " +
                        "WHERE LOWER(trim(both from c.name)) LIKE LOWER(trim(both from :name))", CustomerEntity.class)
                .setParameter("name", name)
                .getResultList();
        return customerEntityList.isEmpty() ? Optional.empty() : Optional.of(customerEntityList.get(0));
    }
}
