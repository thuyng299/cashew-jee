package org.nonit.cashewmanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.nonit.cashewmanagement.entity.GoodsReceivedNoteEntity;
import org.nonit.cashewmanagement.service.model.GoodsReceivedNote;
import org.nonit.cashewmanagement.utils.mapper.BaseMapper;
@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GoodsReceivedNoteMapper extends BaseMapper<GoodsReceivedNoteEntity, GoodsReceivedNote> {

    @Override
    @Mapping(target = "supplierId", source = "supplier.id")
    @Mapping(target = "employeeId", source = "employee.id")
    GoodsReceivedNote toDto(GoodsReceivedNoteEntity goodsReceivedNote);

}
