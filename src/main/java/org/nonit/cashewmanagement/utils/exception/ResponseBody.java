package org.nonit.cashewmanagement.utils.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;

import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class ResponseBody {

    private final String errorKey;
    private final String errorMessage;
    private final Integer statusCode;
    private final String statusMessage;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private final LocalDateTime timeStamp;

    private final UUID uuid;

    public ResponseBody(Response.Status status, String errorKey, String errorMessage) {
        this.errorKey = errorKey;
        this.errorMessage = errorMessage;
        this.statusCode = status.getStatusCode();
        this.statusMessage = status.getReasonPhrase();
        this.timeStamp = LocalDateTime.now();
        this.uuid = UUID.randomUUID();
    }
}
