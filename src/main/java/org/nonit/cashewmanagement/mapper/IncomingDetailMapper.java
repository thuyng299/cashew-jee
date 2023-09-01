//package org.nonit.cashewmanagement.mapper;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.NullValuePropertyMappingStrategy;
//import org.nonit.cashewmanagement.entity.IncomingDetailEntity;
//import org.nonit.cashewmanagement.service.model.IncomingDetail;
//import org.nonit.cashewmanagement.utils.mapper.BaseMapper;
//@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//public interface IncomingDetailMapper extends BaseMapper<IncomingDetailEntity, IncomingDetail> {
//
//    @Override
//    @Mapping(target = "productId", source = "product.id")
//    @Mapping(target = "areaId", source = "warehouseArea.id")
//    @Mapping(target = "grnId", source = "goodsReceivedNote.id")
//    IncomingDetail toDto(IncomingDetailEntity incomingDetail);
//}
