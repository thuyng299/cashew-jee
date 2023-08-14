package org.nonit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.nonit.entity.RegionEntity;
import org.nonit.service.model.Region;
import org.nonit.utils.mapper.BaseMapper;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RegionMapper extends BaseMapper<RegionEntity, Region> {

}
