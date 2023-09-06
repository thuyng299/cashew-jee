package org.nonit.cashewmanagement.service.model;

import lombok.*;
import org.nonit.cashewmanagement.entity.StatusEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static org.nonit.cashewmanagement.utils.exception.ErrorMessage.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    private Long id;

    @NotBlank(message = CUSTOMER_NAME_NULL_OR_BLANK)
    @Size(max = 255, message = CUSTOMER_NAME_LENGTH_CONSTRAINT)
    private String name;

    @NotBlank(message = CUSTOMER_CODE_NULL_OR_BLANK)
    @Size(max = 20, message = CUSTOMER_CODE_LENGTH_CONSTRAINT)
    private String code;

    private String address;

    @NotBlank(message = CUSTOMER_EMAIL_NULL_OR_BLANK)
    @Email(message = CUSTOMER_EMAIL_WRONG_FORMAT)
    private String email;

    @Pattern(regexp="(^[0-9\\-]+$)", message = CUSTOMER_PHONE_WRONG_FORMAT)
    private String phone;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private Long countryId;
}
