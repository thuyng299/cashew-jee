package org.nonit.cashewmanagement.service;

import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.nonit.cashewmanagement.dao.RegionDAO;
import org.nonit.cashewmanagement.entity.RegionEntity;
import org.nonit.cashewmanagement.mapper.RegionMapper;
import org.nonit.cashewmanagement.service.model.Region;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;

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

    public Region create(Region region) {
        RegionEntity createdRegion = RegionEntity.builder()
                .name(region.getName().trim())
                .build();
        return regionMapper.toDto(regionDAO.create(createdRegion));
    }

    public List<Region> getRegionList(){
        List<RegionEntity>regionEntityList = regionDAO.findAll();
        return regionMapper.toDtoList(regionEntityList);
    }
}
