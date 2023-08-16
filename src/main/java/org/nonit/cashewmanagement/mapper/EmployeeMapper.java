package org.nonit.cashewmanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.nonit.cashewmanagement.entity.EmployeeEntity;
import org.nonit.cashewmanagement.service.model.Employee;
import org.nonit.cashewmanagement.utils.mapper.BaseMapper;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EmployeeMapper extends BaseMapper<EmployeeEntity, Employee> {

    @Override
    @Mapping(target = "areaId", source = "warehouseArea.id")
    Employee toDto(EmployeeEntity employee);
}
