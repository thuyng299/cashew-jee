package org.nonit.cashewmanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.nonit.cashewmanagement.service.model.Country;
import org.nonit.cashewmanagement.utils.mapper.BaseMapper;
import org.nonit.cashewmanagement.entity.CountryEntity;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CountryMapper extends BaseMapper<CountryEntity, Country> {

    @Override
    @Mapping(target = "regionId", source = "region.id")
    @Mapping(target = "regionName", source = "region.name")
    Country toDto(CountryEntity country);
}
