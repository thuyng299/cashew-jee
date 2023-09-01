//package org.nonit.cashewmanagement.mapper;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.NullValuePropertyMappingStrategy;
//import org.nonit.cashewmanagement.entity.GoodsDeliveryNoteEntity;
//import org.nonit.cashewmanagement.service.model.GoodsDeliveryNote;
//import org.nonit.cashewmanagement.utils.mapper.BaseMapper;
//@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//public interface GoodsDeliveryNoteMapper extends BaseMapper<GoodsDeliveryNoteEntity, GoodsDeliveryNote> {
//
//    @Override
//    @Mapping(target = "customerId", source = "customer.id")
//    @Mapping(target = "employeeId", source = "employee.id")
//    GoodsDeliveryNote toDto(GoodsDeliveryNoteEntity goodsDeliveryNote);
//}
