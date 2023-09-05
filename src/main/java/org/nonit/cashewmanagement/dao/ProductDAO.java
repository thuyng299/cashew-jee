package org.nonit.cashewmanagement.dao;

import org.nonit.cashewmanagement.entity.CountryEntity;
import org.nonit.cashewmanagement.entity.ProductEntity;
import org.nonit.cashewmanagement.utils.dao.BaseDAO;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Stateless
public class ProductDAO extends BaseDAO<ProductEntity> {

    public ProductDAO(){
        super(ProductEntity.class);
    }

    public Optional<ProductEntity> findByName(String name){
        List<ProductEntity> productEntityList = em.createQuery("SELECT DISTINCT p FROM ProductEntity p " +
                        "WHERE LOWER(trim(both from p.name)) LIKE LOWER(trim(both from :name))", ProductEntity.class)
                .setParameter("name", name)
                .getResultList();
        return productEntityList.isEmpty() ? Optional.empty() : Optional.of(productEntityList.get(0));
    }
}
