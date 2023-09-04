package org.nonit.cashewmanagement.service.model;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
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
public class Supplier {

    private Long id;

    @NotBlank(message = NAME_NULL_OR_BLANK)
    @Size(max = 255, message = NAME_LENGTH_CONSTRAINT)
    private String name;

    @NotBlank(message = CODE_NULL_OR_BLANK)
    @Size(max = 10, message = CODE_LENGTH_CONSTRAINT)
    @UniqueElements(message = SUPPLIER_CODE_TAKEN)
    private String code;

    private String address;

    @NotBlank(message = EMAIL_NULL_OR_BLANK)
    @Email(message = EMAIL_WRONG_FORMAT)
    private String email;

    @Pattern(regexp="(^[0-9\\-]+$)", message = PHONE_WRONG_FORMAT)
    private String phone;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private Long countryId;

}
