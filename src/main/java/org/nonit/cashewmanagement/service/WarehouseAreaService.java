package org.nonit.cashewmanagement.service;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.nonit.cashewmanagement.dao.ProductDAO;
import org.nonit.cashewmanagement.dao.WarehouseAreaDAO;
import org.nonit.cashewmanagement.entity.WarehouseAreaEntity;
import org.nonit.cashewmanagement.mapper.WarehouseAreaMapper;
import org.nonit.cashewmanagement.service.model.WarehouseArea;
import org.nonit.cashewmanagement.utils.exception.ErrorMessage;
import org.nonit.cashewmanagement.utils.exception.InputValidationException;
import org.nonit.cashewmanagement.utils.exception.ResourceNotFoundException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Stateless
public class WarehouseAreaService {

    @Inject
    private WarehouseAreaDAO warehouseAreaDAO;

    @Inject
    private WarehouseAreaMapper warehouseAreaMapper;

    @Inject
    private ProductDAO productDAO;

    private static final Validator validator
            = Validation.byDefaultProvider()
            .configure()
            .messageInterpolator(new ParameterMessageInterpolator())
            .buildValidatorFactory()
            .getValidator();

    public List<WarehouseArea> getAreaList(){

        List<WarehouseAreaEntity> warehouseAreaEntityList = warehouseAreaDAO.findAll();

        return warehouseAreaMapper.toDtoList(warehouseAreaEntityList);
    }
    public WarehouseArea create(WarehouseArea warehouseArea) throws ResourceNotFoundException, InputValidationException{

        verifyArea(warehouseArea);
        WarehouseAreaEntity warehouseAreaEntity = WarehouseAreaEntity.builder()
                .name(warehouseArea.getName().trim())
                .product(productDAO.findById(warehouseArea.getProductId()).orElseThrow(() -> new ResourceNotFoundException(ErrorMessage.KEY_PRODUCT_NOT_FOUND, ErrorMessage.PRODUCT_NOT_FOUND)))
                .build();

        return warehouseAreaMapper.toDto(warehouseAreaDAO.create(warehouseAreaEntity));
    }

    private void verifyArea(WarehouseArea warehouseArea) throws InputValidationException{
        Set<ConstraintViolation<WarehouseArea>> violations = validator.validate(warehouseArea);
        if (CollectionUtils.isNotEmpty(violations)){
            throw new ConstraintViolationException(violations);
        }
        if (isExisted(warehouseArea.getName())){
            throw new InputValidationException(ErrorMessage.KEY_PRODUCT_ALREADY_EXISTED, ErrorMessage.PRODUCT_ALREADY_EXISTED);
        }
    }

    private boolean isExisted(String name) {
        return warehouseAreaDAO.findByName(name.trim().toLowerCase()).isPresent();
    }
}
