package org.nonit.cashewmanagement.service;

import org.nonit.cashewmanagement.dao.CountryDAO;
import org.nonit.cashewmanagement.dao.RegionDAO;
import org.nonit.cashewmanagement.service.model.Country;
import org.nonit.cashewmanagement.entity.CountryEntity;
import org.nonit.cashewmanagement.mapper.CountryMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CountryService {

    @Inject
    private CountryDAO countryDAO;

    @Inject
    private CountryMapper countryMapper;

    @Inject
    private RegionDAO regionDAO;

    public Country create(Country country, Long regionId){
        CountryEntity createdCountry = CountryEntity.builder()
                .name(country.getName())
                .region(regionDAO.findById(regionId).orElseThrow())
                .build();
        return countryMapper.toDto(countryDAO.create(createdCountry));
    }
}
