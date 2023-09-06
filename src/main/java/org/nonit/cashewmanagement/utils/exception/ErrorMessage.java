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
    public static final String SUPPLIER_NAME_NULL_OR_BLANK = "Supplier Name cannot be null or blank";
    public static final String KEY_SUPPLIER_NAME_NULL_OR_BLANK = "exception.input.validation.supplier.name.null.or.blank";
    public static final String  SUPPLIER_NAME_LENGTH_CONSTRAINT = "Supplier Name must be less than 255 characters";
    public static final String KEY_SUPPLIER_NAME_LENGTH_CONSTRAINT = "exception.input.validation.supplier.name.length.over.max.length";
    public static final String SUPPLIER_CODE_NULL_OR_BLANK = "Supplier Code cannot be null or blank";
    public static final String KEY_SUPPLIER_CODE_NULL_OR_BLANK = "exception.input.validation.supplier.code.null.or.blank";
    public static final String SUPPLIER_CODE_LENGTH_CONSTRAINT = "Supplier Code must be less than 20 characters";
    public static final String KEY_SUPPLIER_CODE_LENGTH_CONSTRAINT = "exception.input.validation.supplier.code.length.over.max.length";
    public static final String SUPPLIER_EMAIL_NULL_OR_BLANK = "Supplier Email cannot be null or blank";
    public static final String KEY_SUPPLIER_EMAIL_NULL_OR_BLANK = "exception.input.validation.supplier.email.null.or.blank";
    public static final String SUPPLIER_EMAIL_WRONG_FORMAT = "Supplier Email is not the right format";
    public static final String KEY_SUPPLIER_EMAIL_WRONG_FORMAT = "exception.input.validation.supplier.email.wrong.format";
    public static final String SUPPLIER_PHONE_WRONG_FORMAT = "Supplier Phone must contains digits and dash only";
    public static final String KEY_SUPPLIER_PHONE_WRONG_FORMAT = "exception.input.validation.supplier.phone.wrong.format";
    public static final String SUPPLIER_CODE_TAKEN = "Code is taken";
    public static final String KEY_SUPPLIER_CODE_TAKEN = "exception.input.validation.code.taken";
    public static final String SUPPLIER_ALREADY_EXISTED = "Supplier already existed";
    public static final String KEY_SUPPLIER_ALREADY_EXISTED = "exception.input.validation.supplier.already.existed";

    // Customer
    public static final String CUSTOMER_NAME_NULL_OR_BLANK = "Customer Name cannot be null or blank";
    public static final String KEY_CUSTOMER_NAME_NULL_OR_BLANK = "exception.input.validation.customer.name.null.or.blank";
    public static final String  CUSTOMER_NAME_LENGTH_CONSTRAINT = "Customer Name must be less than 255 characters";
    public static final String KEY_CUSTOMER_NAME_LENGTH_CONSTRAINT = "exception.input.validation.customer.name.length.over.max.length";
    public static final String CUSTOMER_CODE_NULL_OR_BLANK = "Customer Code cannot be null or blank";
    public static final String KEY_CUSTOMER_CODE_NULL_OR_BLANK = "exception.input.validation.customer.code.null.or.blank";
    public static final String CUSTOMER_CODE_LENGTH_CONSTRAINT = "Customer Code must be less than 20 characters";
    public static final String KEY_CUSTOMER_CODE_LENGTH_CONSTRAINT = "exception.input.validation.customer.code.length.over.max.length";
    public static final String CUSTOMER_EMAIL_NULL_OR_BLANK = "Customer Email cannot be null or blank";
    public static final String KEY_CUSTOMER_EMAIL_NULL_OR_BLANK = "exception.input.validation.customer.email.null.or.blank";
    public static final String CUSTOMER_EMAIL_WRONG_FORMAT = "Customer Email is not the right format";
    public static final String KEY_CUSTOMER_EMAIL_WRONG_FORMAT = "exception.input.validation.customer.email.wrong.format";
    public static final String CUSTOMER_PHONE_WRONG_FORMAT = "Customer Phone must contains digits and dash only";
    public static final String KEY_CUSTOMER_PHONE_WRONG_FORMAT = "exception.input.validation.customer.phone.wrong.format";
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
    public static final String PRODUCT_NOT_FOUND = "Product not found";
    public static final String KEY_PRODUCT_NOT_FOUND = "exception.resource.product.not.found";

    // Area
    public static final String AREA_NAME_NULL_OR_BLANK = "Area Name cannot be null or blank";
    public static final String KEY_AREA_NAME_NULL_OR_BLANK = "exception.input.validation.area.name.null.or.blank";
    public static final String AREA_NAME_LENGTH_CONSTRAINT = "Area Name must be less than 255 characters";
    public static final String KEY_AREA_NAME_LENGTH_CONSTRAINT = "exception.input.validation.area.name.length.invalid";

    private ErrorMessage() {

    }

    static Map<String, String> errorKeyAndMessageMap() {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put(REGION_NAME_NULL_OR_BLANK, KEY_REGION_NAME_NULL_OR_BLANK);
        errorMap.put(REGION_NAME_LENGTH_CONSTRAINT, KEY_REGION_NAME_LENGTH_CONSTRAINT);
        errorMap.put(REGION_ALREADY_EXISTED, KEY_REGION_ALREADY_EXISTED);

        errorMap.put(COUNTRY_NAME_NULL_OR_BLANK, KEY_COUNTRY_NAME_NULL_OR_BLANK);
        errorMap.put(COUNTRY_NAME_LENGTH_CONSTRAINT, KEY_COUNTRY_NAME_LENGTH_CONSTRAINT);

        errorMap.put(SUPPLIER_NAME_NULL_OR_BLANK, KEY_SUPPLIER_NAME_NULL_OR_BLANK);
        errorMap.put(SUPPLIER_NAME_LENGTH_CONSTRAINT, KEY_SUPPLIER_NAME_LENGTH_CONSTRAINT);
        errorMap.put(SUPPLIER_CODE_NULL_OR_BLANK, KEY_SUPPLIER_CODE_NULL_OR_BLANK);
        errorMap.put(SUPPLIER_CODE_LENGTH_CONSTRAINT, KEY_SUPPLIER_CODE_LENGTH_CONSTRAINT);
        errorMap.put(SUPPLIER_CODE_TAKEN, KEY_SUPPLIER_CODE_TAKEN);
        errorMap.put(SUPPLIER_EMAIL_NULL_OR_BLANK, KEY_SUPPLIER_EMAIL_NULL_OR_BLANK);
        errorMap.put(SUPPLIER_EMAIL_WRONG_FORMAT, KEY_SUPPLIER_EMAIL_WRONG_FORMAT);
        errorMap.put(SUPPLIER_PHONE_WRONG_FORMAT, KEY_SUPPLIER_PHONE_WRONG_FORMAT);

        errorMap.put(CUSTOMER_NAME_NULL_OR_BLANK, KEY_CUSTOMER_NAME_NULL_OR_BLANK);
        errorMap.put(CUSTOMER_NAME_LENGTH_CONSTRAINT, KEY_CUSTOMER_NAME_LENGTH_CONSTRAINT);
        errorMap.put(CUSTOMER_CODE_NULL_OR_BLANK, KEY_CUSTOMER_CODE_NULL_OR_BLANK);
        errorMap.put(CUSTOMER_CODE_LENGTH_CONSTRAINT, KEY_CUSTOMER_CODE_LENGTH_CONSTRAINT);
//        errorMap.put(CUSTOMER_CODE_TAKEN, KEY_SUPPLIER_CODE_TAKEN);
        errorMap.put(CUSTOMER_EMAIL_NULL_OR_BLANK, KEY_CUSTOMER_EMAIL_NULL_OR_BLANK);
        errorMap.put(CUSTOMER_EMAIL_WRONG_FORMAT, KEY_CUSTOMER_EMAIL_WRONG_FORMAT);
        errorMap.put(CUSTOMER_PHONE_WRONG_FORMAT, KEY_CUSTOMER_PHONE_WRONG_FORMAT);

        errorMap.put(PRODUCT_NAME_NULL_OR_BLANK, KEY_PRODUCT_NAME_NULL_OR_BLANK);
        errorMap.put(PRODUCT_NAME_LENGTH_CONSTRAINT, KEY_PRODUCT_NAME_LENGTH_CONSTRAINT);
        errorMap.put(PRODUCT_CODE_NULL_OR_BLANK, KEY_PRODUCT_CODE_NULL_OR_BLANK);
        errorMap.put(PRODUCT_CODE_LENGTH_CONSTRAINT, KEY_PRODUCT_CODE_LENGTH_CONSTRAINT);
        errorMap.put(PRODUCT_DESCRIPTION_LENGTH_CONSTRAINT, KEY_PRODUCT_DESCRIPTION_LENGTH_CONSTRAINT);

        errorMap.put(AREA_NAME_NULL_OR_BLANK, KEY_AREA_NAME_NULL_OR_BLANK);
        errorMap.put(AREA_NAME_LENGTH_CONSTRAINT, KEY_AREA_NAME_LENGTH_CONSTRAINT);

        return errorMap;
    }
}
