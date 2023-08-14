package org.nonit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.nonit.entity.CountryEntity;
import org.nonit.service.model.Country;
import org.nonit.utils.mapper.BaseMapper;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CountryMapper extends BaseMapper<CountryEntity, Country> {

    @Override
    @Mapping(target = "regionId", source = "region.id")
    @Mapping(target = "regionName", source = "region.name")
    Country toDto(CountryEntity country);
}
