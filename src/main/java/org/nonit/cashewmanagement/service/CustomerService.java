package org.nonit.cashewmanagement.service;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.nonit.cashewmanagement.dao.CountryDAO;
import org.nonit.cashewmanagement.dao.CustomerDAO;
import org.nonit.cashewmanagement.entity.CustomerEntity;
import org.nonit.cashewmanagement.entity.StatusEnum;
import org.nonit.cashewmanagement.mapper.CustomerMapper;
import org.nonit.cashewmanagement.service.model.Customer;
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
public class CustomerService {

    @Inject
    private CustomerDAO customerDAO;

    @Inject
    private CustomerMapper customerMapper;

    @Inject
    private CountryDAO countryDAO;

    private static final Validator validator
            = Validation.byDefaultProvider()
            .configure()
            .messageInterpolator(new ParameterMessageInterpolator())
            .buildValidatorFactory()
            .getValidator();

    public List<Customer> getActiveList(){

        List<CustomerEntity> customerEntityList = customerDAO.findByStatus(StatusEnum.ACTIVE);

        return customerMapper.toDtoList(customerEntityList);
    }
    public Customer create(Customer customer) throws ResourceNotFoundException, InputValidationException{
        verifyCustomer(customer);

        CustomerEntity customerEntity = CustomerEntity.builder()
                .name(customer.getName().trim())
                .code(customer.getCode().trim())
                .address(customer.getAddress() == null ? null : customer.getAddress().trim())
                .email(customer.getEmail())
                .phone(customer.getPhone() == null ? null : customer.getPhone().trim())
                .status(StatusEnum.ACTIVE)
                .country(countryDAO.findById(customer.getCountryId()).orElseThrow(() -> new ResourceNotFoundException(ErrorMessage.KEY_COUNTRY_NOT_FOUND, ErrorMessage.COUNTRY_NOT_FOUND)))
                .build();

        return customerMapper.toDto(customerEntity);
    }

    private void verifyCustomer(Customer customer) throws InputValidationException{
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        if (CollectionUtils.isNotEmpty(violations)){
            throw new ConstraintViolationException(violations);
        }
        if (isExisted(customer.getName())){
            throw new InputValidationException(ErrorMessage.KEY_CUSTOMER_ALREADY_EXISTED, ErrorMessage.CUSTOMER_ALREADY_EXISTED);
        }
    }

    private boolean isExisted(String name) {
        return customerDAO.findByName(name.trim().toLowerCase()).isPresent();
    }
}
