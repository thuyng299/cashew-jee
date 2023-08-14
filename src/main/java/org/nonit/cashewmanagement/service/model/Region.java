package org.nonit.cashewmanagement.service.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static org.nonit.cashewmanagement.utils.exception.ErrorMessage.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    private Long id;

    @NotBlank(message = REGION_NAME_NULL_OR_BLANK)
    @Size(min = 3, max = 30, message = REGION_NAME_LENGTH_CONSTRAINT)
    private String name;

}
