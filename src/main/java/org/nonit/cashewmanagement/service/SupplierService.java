package org.nonit.cashewmanagement.service;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.nonit.cashewmanagement.dao.CountryDAO;
import org.nonit.cashewmanagement.dao.SupplierDAO;
import org.nonit.cashewmanagement.entity.StatusEnum;
import org.nonit.cashewmanagement.entity.SupplierEntity;
import org.nonit.cashewmanagement.mapper.SupplierMapper;
import org.nonit.cashewmanagement.service.model.Supplier;
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
public class SupplierService {

    @Inject
    private SupplierDAO supplierDAO;

    @Inject
    private SupplierMapper supplierMapper;

    @Inject
    private CountryDAO countryDAO;

    private static final Validator validator
            = Validation.byDefaultProvider()
            .configure()
            .messageInterpolator(new ParameterMessageInterpolator())
            .buildValidatorFactory()
            .getValidator();

    public List<Supplier> getActiveList(){

        List<SupplierEntity> supplierEntityList = supplierDAO.findByStatus(StatusEnum.ACTIVE);

        return supplierMapper.toDtoList(supplierEntityList);
    }
    public Supplier create(Supplier supplier) throws ResourceNotFoundException, InputValidationException {
        verifySupplier(supplier);

        SupplierEntity createdSupplier = SupplierEntity.builder()
                .name(supplier.getName().trim())
                .code(supplier.getCode().trim())
                .address(supplier.getAddress() == null ? null : supplier.getAddress().trim())
                .email(supplier.getEmail())
                .phone(supplier.getPhone() == null ? null : supplier.getPhone().trim())
                .status(StatusEnum.ACTIVE)
                .country(countryDAO.findById(supplier.getCountryId()).orElseThrow(() -> new ResourceNotFoundException(ErrorMessage.KEY_COUNTRY_NOT_FOUND, ErrorMessage.COUNTRY_NOT_FOUND)))
                .build();

        return supplierMapper.toDto(supplierDAO.create(createdSupplier));
    }

    private void verifySupplier(Supplier supplier) throws InputValidationException {
        Set<ConstraintViolation<Supplier>> violations = validator.validate(supplier);
        if (CollectionUtils.isNotEmpty(violations)) {
            throw new ConstraintViolationException(violations);
        }

        if (isExisted(supplier.getName())) {
            throw new InputValidationException(ErrorMessage.KEY_SUPPLIER_ALREADY_EXISTED, ErrorMessage.SUPPLIER_ALREADY_EXISTED);
        }
    }

    private boolean isExisted(String name) {
        return supplierDAO.findByName(name.trim().toLowerCase()).isPresent();
    }
}
