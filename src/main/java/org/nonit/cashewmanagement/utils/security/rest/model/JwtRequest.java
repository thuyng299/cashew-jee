package org.nonit.cashewmanagement.utils.security.rest.model;

import lombok.*;

import javax.validation.constraints.NotBlank;

import static org.nonit.cashewmanagement.utils.exception.ErrorMessage.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtRequest {

    @NotBlank(message = EMPLOYEE_USERNAME_NULL_OR_BLANK)
    private String username;

    @NotBlank(message = PASSWORD_BLANK_OR_NULL)
    private String password;
}
