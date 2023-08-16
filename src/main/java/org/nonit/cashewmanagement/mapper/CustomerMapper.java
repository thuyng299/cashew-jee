package org.nonit.cashewmanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.nonit.cashewmanagement.entity.CustomerEntity;
import org.nonit.cashewmanagement.service.model.Customer;
import org.nonit.cashewmanagement.utils.mapper.BaseMapper;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerMapper extends BaseMapper<CustomerEntity, Customer> {

    @Override
    @Mapping(target = "countryId", source = "country.id")
    Customer toDto(CustomerEntity customer);
}
