package org.nonit.utils.exception;

import java.util.HashMap;
import java.util.Map;

public class ErrorMessage {

    private ErrorMessage() {

    }

    static Map<String, String> errorKeyAndMessageMap() {
        Map<String, String> errorMap = new HashMap<>();
        return errorMap;
    }
}
