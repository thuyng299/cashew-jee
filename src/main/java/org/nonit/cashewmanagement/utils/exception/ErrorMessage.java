package org.nonit.cashewmanagement.utils.exception;

import java.util.HashMap;
import java.util.Map;

public class ErrorMessage {

    // Region
    public static final String REGION_NAME_NULL_OR_BLANK = "Region Name cannot be null or blank";
    public static final String KEY_REGION_NAME_NULL_OR_BLANK = "exception.input.validation.region.name.null.or.blank";
    public static final String REGION_NAME_LENGTH_CONSTRAINT = "Region Name must have at least 3 characters and less than 30 characters";
    public static final String KEY_REGION_NAME_LENGTH_CONSTRAINT = "exception.input.validation.region.name.length.invalid";
    public static final String REGION_ALREADY_EXISTED = "Region already existed";
    public static final String KEY_REGION_ALREADY_EXISTED = "exception.input.validation.region.already.existed";
    public static final String REGION_NOT_FOUND = "Region not found";
    public static final String KEY_REGION_NOT_FOUND = "exception.resource.region.not.found";

    // Country
    public static final String COUNTRY_NAME_NULL_OR_BLANK = "Country Name cannot be null or blank";
    public static final String KEY_COUNTRY_NAME_NULL_OR_BLANK = "exception.input.validation.country.name.null.or.blank";
    public static final String COUNTRY_NAME_LENGTH_CONSTRAINT = "Country Name cannot exceed 255 characters";
    public static final String KEY_COUNTRY_NAME_LENGTH_CONSTRAINT = "exception.input.validation.country.name.length.over.max.length";
    public static final String COUNTRY_ALREADY_EXISTED = "Country already existed";
    public static final String KEY_COUNTRY_ALREADY_EXISTED = "exception.input.validation.country.already.existed";


    // Supplier
    public static final String NAME_NULL_OR_BLANK = "Name cannot be null or blank";
    public static final String KEY_NAME_NULL_OR_BLANK = "exception.input.validation.name.null.or.blank";
    public static final String NAME_LENGTH_CONSTRAINT = "Name cannot exceed 255 characters";
    public static final String KEY_NAME_LENGTH_CONSTRAINT = "exception.input.validation.name.length.over.max.length";
    public static final String CODE_NULL_OR_BLANK = "Code cannot be null or blank";
    public static final String KEY_CODE_NULL_OR_BLANK = "exception.input.validation.code.null.or.blank";
    public static final String CODE_LENGTH_CONSTRAINT = "Code cannot exceed 10 characters";
    public static final String KEY_CODE_LENGTH_CONSTRAINT = "exception.input.validation.code.length.over.max.length";
    public static final String EMAIL_NULL_OR_BLANK = "Email cannot be null or blank";
    public static final String KEY__EMAIL_NULL_OR_BLANK = "exception.input.validation.email.null.or.blank";
    public static final String EMAIL_WRONG_FORMAT = "Email is not the right format";
    public static final String KEY_EMAIL_WRONG_FORMAT = "exception.input.validation.email.wrong.format";

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
        errorMap.put(EMAIL_NULL_OR_BLANK, KEY__EMAIL_NULL_OR_BLANK);
        errorMap.put(EMAIL_WRONG_FORMAT, KEY_EMAIL_WRONG_FORMAT);

        return errorMap;
    }
}
