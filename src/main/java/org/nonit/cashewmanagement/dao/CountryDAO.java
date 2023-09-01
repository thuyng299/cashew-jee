package org.nonit.cashewmanagement.dao;

import org.nonit.cashewmanagement.entity.CountryEntity;
import org.nonit.cashewmanagement.utils.dao.BaseDAO;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Stateless
public class CountryDAO extends BaseDAO<CountryEntity> {

    public CountryDAO(){
        super(CountryEntity.class);
    }

    public Optional<CountryEntity> findByName(String name){
        List<CountryEntity> countryEntityList = em.createQuery("SELECT DISTINCT c FROM CountryEntity c " +
                "WHERE LOWER(trim(both from c.name)) LIKE LOWER(trim(both from :name))", CountryEntity.class)
                .setParameter("name", name)
                .getResultList();
        return countryEntityList.isEmpty() ? Optional.empty() : Optional.of(countryEntityList.get(0));
    }
}
