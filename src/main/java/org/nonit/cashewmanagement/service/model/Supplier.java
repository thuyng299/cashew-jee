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
import static org.nonit.cashewmanagement.utils.exception.ErrorMessage.SUPPLIER_PHONE_WRONG_FORMAT;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Supplier {

    private Long id;

    @NotBlank(message = SUPPLIER_NAME_NULL_OR_BLANK)
    @Size(max = 255, message = SUPPLIER_NAME_LENGTH_CONSTRAINT)
    private String name;

    @NotBlank(message = SUPPLIER_CODE_NULL_OR_BLANK)
    @Size(max = 10, message = SUPPLIER_CODE_LENGTH_CONSTRAINT)
    private String code;

    private String address;

    @NotBlank(message = SUPPLIER_EMAIL_NULL_OR_BLANK)
    @Email(message = SUPPLIER_EMAIL_WRONG_FORMAT)
    private String email;

    @Pattern(regexp="(^[0-9\\-]+$)", message = SUPPLIER_PHONE_WRONG_FORMAT)
    private String phone;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private Long countryId;

}
