package org.nonit.cashewmanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.nonit.cashewmanagement.entity.SupplierEntity;
import org.nonit.cashewmanagement.service.model.Supplier;
import org.nonit.cashewmanagement.utils.mapper.BaseMapper;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SupplierMapper extends BaseMapper<SupplierEntity, Supplier> {

    @Override
    @Mapping(target = "countryId", source = "country.id")
    Supplier toDto(SupplierEntity supplier);
}
