package org.nonit.service;

import org.nonit.dao.CountryDAO;
import org.nonit.dao.RegionDAO;
import org.nonit.entity.CountryEntity;
import org.nonit.mapper.CountryMapper;
import org.nonit.service.model.Country;

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
