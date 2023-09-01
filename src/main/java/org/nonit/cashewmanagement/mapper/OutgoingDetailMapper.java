//package org.nonit.cashewmanagement.mapper;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.NullValuePropertyMappingStrategy;
//import org.nonit.cashewmanagement.entity.OutgoingDetailEntity;
//import org.nonit.cashewmanagement.service.model.OutgoingDetail;
//import org.nonit.cashewmanagement.utils.mapper.BaseMapper;
//@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//public interface OutgoingDetailMapper extends BaseMapper<OutgoingDetailEntity, OutgoingDetail> {
//
//    @Override
//    @Mapping(target = "productId", source = "product.id")
//    @Mapping(target = "incomingId", source = "incomingDetail.id")
//    @Mapping(target = "gdnId", source = "goodsDeliveryNote.id")
//    OutgoingDetail toDto(OutgoingDetailEntity outgoingDetail);
//}
