package org.nonit.cashewmanagement.utils.exception;

import java.util.HashMap;
import java.util.Map;

public class ErrorMessage {

    public static final String REGION_NAME_NULL_OR_BLANK = "Region Name cannot be null or blank";

    public static final String KEY_REGION_NAME_NULL_OR_BLANK = "exception.input.validation.region.name.null.or.blank";

    public static final String REGION_NAME_LENGTH_CONSTRAINT = "Region Name must have at least 3 characters and less than 30 characters";

    public static final String KEY_REGION_NAME_LENGTH_CONSTRAINT = "exception.input.validation.region.name.length.invalid";

    public static final String REGION_ALREADY_EXISTED = "Region already existed";

    public static final String KEY_REGION_ALREADY_EXISTED = "exception.input.validation.region.already.existed";
    private ErrorMessage() {

    }

    static Map<String, String> errorKeyAndMessageMap() {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put(REGION_NAME_NULL_OR_BLANK, KEY_REGION_NAME_NULL_OR_BLANK);
        errorMap.put(REGION_NAME_LENGTH_CONSTRAINT, KEY_REGION_NAME_LENGTH_CONSTRAINT);
        errorMap.put(REGION_ALREADY_EXISTED, KEY_REGION_ALREADY_EXISTED);

        return errorMap;
    }
}
