package org.nonit.cashewmanagement.service.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static org.nonit.cashewmanagement.utils.exception.ErrorMessage.COUNTRY_NAME_LENGTH_CONSTRAINT;
import static org.nonit.cashewmanagement.utils.exception.ErrorMessage.COUNTRY_NAME_NULL_OR_BLANK;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Country {

    private Long id;

    @NotBlank(message = COUNTRY_NAME_NULL_OR_BLANK)
    @Size(max = 255, message = COUNTRY_NAME_LENGTH_CONSTRAINT)
    private String name;

    private Long regionId;

    private String regionName;
}
