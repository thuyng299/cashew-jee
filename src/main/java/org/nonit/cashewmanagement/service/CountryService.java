package org.nonit.cashewmanagement.service;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.nonit.cashewmanagement.dao.CountryDAO;
import org.nonit.cashewmanagement.dao.RegionDAO;
import org.nonit.cashewmanagement.service.model.Country;
import org.nonit.cashewmanagement.entity.CountryEntity;
import org.nonit.cashewmanagement.mapper.CountryMapper;
import org.nonit.cashewmanagement.utils.exception.ErrorMessage;
import org.nonit.cashewmanagement.utils.exception.InputValidationException;
import org.nonit.cashewmanagement.utils.exception.ResourceNotFoundException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Stateless
public class CountryService {

    @Inject
    private CountryDAO countryDAO;

    @Inject
    private CountryMapper countryMapper;

    @Inject
    private RegionDAO regionDAO;

    private static final Validator validator
            = Validation.byDefaultProvider()
            .configure()
            .messageInterpolator(new ParameterMessageInterpolator())
            .buildValidatorFactory()
            .getValidator();

    public List<Country> getCountryList() {

        List<CountryEntity> countryEntityList = countryDAO.findAll();

        return countryMapper.toDtoList(countryEntityList);
    }

    public Country create(Country country) throws InputValidationException, ResourceNotFoundException {
        verifyCountry(country);

        CountryEntity createdCountry = CountryEntity.builder()
                .name(country.getName().trim())
                .region(regionDAO.findById(country.getRegionId()).orElseThrow(() -> new ResourceNotFoundException(ErrorMessage.KEY_REGION_NOT_FOUND, ErrorMessage.REGION_NOT_FOUND)))
                .build();

        return countryMapper.toDto(countryDAO.create(createdCountry));
    }

    private void verifyCountry(Country country) throws InputValidationException {
        Set<ConstraintViolation<Country>> violations = validator.validate(country);
        if (CollectionUtils.isNotEmpty(violations)) {
            throw new ConstraintViolationException(violations);
        }

        if (isExisted(country.getName())) {
            throw new InputValidationException(ErrorMessage.KEY_COUNTRY_ALREADY_EXISTED,
                    ErrorMessage.COUNTRY_ALREADY_EXISTED);
        }
    }

    private boolean isExisted(String name) {
        return countryDAO.findByName(name.trim().toLowerCase()).isPresent();
    }

}
