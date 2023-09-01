package org.nonit.cashewmanagement.service;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.nonit.cashewmanagement.dao.RegionDAO;
import org.nonit.cashewmanagement.entity.RegionEntity;
import org.nonit.cashewmanagement.mapper.RegionMapper;
import org.nonit.cashewmanagement.service.model.Region;
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
public class RegionService {
    @Inject
    private RegionDAO regionDAO;

    @Inject
    private RegionMapper regionMapper;

    private static final Validator validator
            = Validation.byDefaultProvider()
            .configure()
            .messageInterpolator(new ParameterMessageInterpolator())
            .buildValidatorFactory()
            .getValidator();

    public List<Region> getRegionList() {
        List<RegionEntity> regionEntityList = regionDAO.findAll();
        return regionMapper.toDtoList(regionEntityList);
    }

    public Region create(Region region) throws InputValidationException {
        verifyRegion(region);

        RegionEntity createdRegion = RegionEntity.builder()
                .name(region.getName().trim())
                .build();
        return regionMapper.toDto(regionDAO.create(createdRegion));
    }

    private void verifyRegion(Region region) throws InputValidationException {
        trimRegionName(region);

        Set<ConstraintViolation<Region>> violations = validator.validate(region);
        if (CollectionUtils.isNotEmpty(violations)) {
            throw new ConstraintViolationException(violations);
        }
        if (isExisted(region.getName())) {
            throw new InputValidationException(ErrorMessage.KEY_REGION_ALREADY_EXISTED,
                    ErrorMessage.REGION_ALREADY_EXISTED);
        }
    }

    private void trimRegionName(Region region) {
        if (region.getName() != null) {
            region.setName(region.getName().trim());
        }
    }

    private boolean isExisted(String name) {
        return regionDAO.findByName(name.trim().toLowerCase()).isPresent();
    }

    public void delete(Long id) throws ResourceNotFoundException {
      regionDAO.delete(id);
//        if (deletedRegion == null){
//            throw new ResourceNotFoundException(ErrorMessage.KEY_REGION_NOT_FOUND, ErrorMessage.REGION_NOT_FOUND);
//        }
    }
}
