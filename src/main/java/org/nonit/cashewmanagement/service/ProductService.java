package org.nonit.cashewmanagement.service;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.nonit.cashewmanagement.dao.ProductDAO;
import org.nonit.cashewmanagement.entity.ProductEntity;
import org.nonit.cashewmanagement.mapper.ProductMapper;
import org.nonit.cashewmanagement.service.model.Product;
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
public class ProductService {

    @Inject
    private ProductDAO productDAO;

    @Inject
    private ProductMapper productMapper;

    private static final Validator validator
            = Validation.byDefaultProvider()
            .configure()
            .messageInterpolator(new ParameterMessageInterpolator())
            .buildValidatorFactory()
            .getValidator();

    public List<Product> getProductList(){

        List<ProductEntity> productEntityList = productDAO.findAll();

        return productMapper.toDtoList(productEntityList);
    }

    public Product create(Product product) throws ResourceNotFoundException, InputValidationException {

        verifyProduct(product);
        ProductEntity productEntity = ProductEntity.builder()
                .name(product.getName().trim())
                .code(product.getCode().trim())
                .description(product.getDescription() == null ? null : product.getDescription().trim())
                .productCategory(product.getProductCategory())
                .build();

        return productMapper.toDto(productEntity);
    }

    private void verifyProduct(Product product) throws InputValidationException{
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        if (CollectionUtils.isNotEmpty(violations)){
            throw new ConstraintViolationException(violations);
        }
        if (isExisted(product.getName())){
            throw new InputValidationException(ErrorMessage.KEY_PRODUCT_ALREADY_EXISTED, ErrorMessage.PRODUCT_ALREADY_EXISTED);
        }
    }

    private boolean isExisted(String name){
        return productDAO.findByName(name.trim().toLowerCase()).isPresent();
    }
}
