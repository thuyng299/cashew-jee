package org.nonit.cashewmanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.nonit.cashewmanagement.entity.RegionEntity;
import org.nonit.cashewmanagement.service.model.Region;
import org.nonit.cashewmanagement.utils.mapper.BaseMapper;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RegionMapper extends BaseMapper<RegionEntity, Region> {

}
