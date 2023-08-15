package org.nonit.cashewmanagement.service.model;

import lombok.*;
import org.nonit.cashewmanagement.entity.StatusEnum;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static org.nonit.cashewmanagement.utils.exception.ErrorMessage.*;
import static org.nonit.cashewmanagement.utils.exception.ErrorMessage.EMAIL_WRONG_FORMAT;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    private Long id;

    @NotBlank(message = NAME_NULL_OR_BLANK)
    @Size(max = 255, message = NAME_LENGTH_CONSTRAINT)
    private String name;

    @NotBlank(message = CODE_NULL_OR_BLANK)
    @Size(max = 10, message = CODE_LENGTH_CONSTRAINT)
    private String code;

    private String address;

    @NotBlank(message = EMAIL_NULL_OR_BLANK)
    @Email(message = EMAIL_WRONG_FORMAT)
    private String email;

    private String phone;

    private StatusEnum status;

    private Long countryId;
}
