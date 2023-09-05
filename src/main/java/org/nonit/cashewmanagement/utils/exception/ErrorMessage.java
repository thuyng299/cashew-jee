package org.nonit.cashewmanagement.utils.exception;

import java.util.HashMap;
import java.util.Map;

public class ErrorMessage {

    // Region
    public static final String REGION_NAME_NULL_OR_BLANK = "Region Name cannot be null or blank";
    public static final String KEY_REGION_NAME_NULL_OR_BLANK = "exception.input.validation.region.name.null.or.blank";
    public static final String REGION_NAME_LENGTH_CONSTRAINT = "Region Name must be at least 3 characters and less than 30 characters";
    public static final String KEY_REGION_NAME_LENGTH_CONSTRAINT = "exception.input.validation.region.name.length.invalid";
    public static final String REGION_ALREADY_EXISTED = "Region already existed";
    public static final String KEY_REGION_ALREADY_EXISTED = "exception.input.validation.region.already.existed";
    public static final String REGION_NOT_FOUND = "Region not found";
    public static final String KEY_REGION_NOT_FOUND = "exception.resource.region.not.found";

    // Country
    public static final String COUNTRY_NAME_NULL_OR_BLANK = "Country Name cannot be null or blank";
    public static final String KEY_COUNTRY_NAME_NULL_OR_BLANK = "exception.input.validation.country.name.null.or.blank";
    public static final String COUNTRY_NAME_LENGTH_CONSTRAINT = "Country Name must be less than 255 characters";
    public static final String KEY_COUNTRY_NAME_LENGTH_CONSTRAINT = "exception.input.validation.country.name.length.over.max.length";
    public static final String COUNTRY_ALREADY_EXISTED = "Country already existed";
    public static final String KEY_COUNTRY_ALREADY_EXISTED = "exception.input.validation.country.already.existed";
    public static final String COUNTRY_NOT_FOUND = "Country not found";
    public static final String KEY_COUNTRY_NOT_FOUND = "exception.resource.country.not.found";


    // Supplier
    public static final String NAME_NULL_OR_BLANK = "Name cannot be null or blank";
    public static final String KEY_NAME_NULL_OR_BLANK = "exception.input.validation.name.null.or.blank";
    public static final String NAME_LENGTH_CONSTRAINT = "Name must be less than 255 characters";
    public static final String KEY_NAME_LENGTH_CONSTRAINT = "exception.input.validation.name.length.over.max.length";
    public static final String CODE_NULL_OR_BLANK = "Code cannot be null or blank";
    public static final String KEY_CODE_NULL_OR_BLANK = "exception.input.validation.code.null.or.blank";
    public static final String CODE_LENGTH_CONSTRAINT = "Code must be less than 20 characters";
    public static final String KEY_CODE_LENGTH_CONSTRAINT = "exception.input.validation.code.length.over.max.length";
    public static final String EMAIL_NULL_OR_BLANK = "Email cannot be null or blank";
    public static final String KEY__EMAIL_NULL_OR_BLANK = "exception.input.validation.email.null.or.blank";
    public static final String EMAIL_WRONG_FORMAT = "Email is not the right format";
    public static final String KEY_EMAIL_WRONG_FORMAT = "exception.input.validation.email.wrong.format";
    public static final String PHONE_WRONG_FORMAT = "Phone must contains digits and dash only";
    public static final String KEY_PHONE_WRONG_FORMAT = "exception.input.validation.phone.wrong.format";
    public static final String SUPPLIER_CODE_TAKEN = "Code is taken";
    public static final String KEY_SUPPLIER_CODE_TAKEN = "exception.input.validation.code.taken";
    public static final String SUPPLIER_ALREADY_EXISTED = "Supplier already existed";
    public static final String KEY_SUPPLIER_ALREADY_EXISTED = "exception.input.validation.supplier.already.existed";

    // Customer
    public static final String CUSTOMER_ALREADY_EXISTED = "Customer already existed";
    public static final String KEY_CUSTOMER_ALREADY_EXISTED = "exception.input.validation.customer.already.existed";

    // Product
    public static final String PRODUCT_NAME_NULL_OR_BLANK = "Product Name cannot be null or blank";
    public static final String KEY_PRODUCT_NAME_NULL_OR_BLANK = "exception.input.validation.product.name.null.or.blank";
    public static final String PRODUCT_NAME_LENGTH_CONSTRAINT = "Product Name must be at least 5 characters and less than 50 characters";
    public static final String KEY_PRODUCT_NAME_LENGTH_CONSTRAINT = "exception.input.validation.product.name.length.invalid";
    public static final String PRODUCT_CODE_NULL_OR_BLANK = "Product Code cannot be null or blank";
    public static final String KEY_PRODUCT_CODE_NULL_OR_BLANK = "exception.input.validation.product.code.null.or.blank";
    public static final String PRODUCT_CODE_LENGTH_CONSTRAINT = "Product Code must be less than 10 characters";
    public static final String KEY_PRODUCT_CODE_LENGTH_CONSTRAINT = "exception.input.validation.product.code.length.over.max.length";
    public static final String PRODUCT_DESCRIPTION_LENGTH_CONSTRAINT = "Product Description must be less than 1000 characters";
    public static final String KEY_PRODUCT_DESCRIPTION_LENGTH_CONSTRAINT = "exception.input.validation.product.description.length.over.max.length";
    public static final String PRODUCT_ALREADY_EXISTED = "Product already existed";
    public static final String KEY_PRODUCT_ALREADY_EXISTED = "exception.input.validation.product.already.existed";

    private ErrorMessage() {

    }

    static Map<String, String> errorKeyAndMessageMap() {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put(REGION_NAME_NULL_OR_BLANK, KEY_REGION_NAME_NULL_OR_BLANK);
        errorMap.put(REGION_NAME_LENGTH_CONSTRAINT, KEY_REGION_NAME_LENGTH_CONSTRAINT);
        errorMap.put(REGION_ALREADY_EXISTED, KEY_REGION_ALREADY_EXISTED);

        errorMap.put(COUNTRY_NAME_NULL_OR_BLANK, KEY_COUNTRY_NAME_NULL_OR_BLANK);
        errorMap.put(COUNTRY_NAME_LENGTH_CONSTRAINT, KEY_COUNTRY_NAME_LENGTH_CONSTRAINT);

        errorMap.put(NAME_NULL_OR_BLANK, KEY_NAME_NULL_OR_BLANK);
        errorMap.put(NAME_LENGTH_CONSTRAINT, KEY_NAME_LENGTH_CONSTRAINT);
        errorMap.put(CODE_NULL_OR_BLANK, KEY_CODE_NULL_OR_BLANK);
        errorMap.put(CODE_LENGTH_CONSTRAINT, KEY_CODE_LENGTH_CONSTRAINT);
        errorMap.put(SUPPLIER_CODE_TAKEN, KEY_SUPPLIER_CODE_TAKEN);
        errorMap.put(EMAIL_NULL_OR_BLANK, KEY__EMAIL_NULL_OR_BLANK);
        errorMap.put(EMAIL_WRONG_FORMAT, KEY_EMAIL_WRONG_FORMAT);
        errorMap.put(PHONE_WRONG_FORMAT, KEY_PHONE_WRONG_FORMAT);

        errorMap.put(PRODUCT_NAME_NULL_OR_BLANK, KEY_PRODUCT_NAME_NULL_OR_BLANK);
        errorMap.put(PRODUCT_NAME_LENGTH_CONSTRAINT, KEY_PRODUCT_NAME_LENGTH_CONSTRAINT);
        errorMap.put(PRODUCT_CODE_NULL_OR_BLANK, KEY_PRODUCT_CODE_NULL_OR_BLANK);
        errorMap.put(PRODUCT_CODE_LENGTH_CONSTRAINT, KEY_PRODUCT_CODE_LENGTH_CONSTRAINT);
        errorMap.put(PRODUCT_DESCRIPTION_LENGTH_CONSTRAINT, KEY_PRODUCT_DESCRIPTION_LENGTH_CONSTRAINT);

        return errorMap;
    }
}
