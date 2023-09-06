package org.nonit.cashewmanagement.service.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static org.nonit.cashewmanagement.utils.exception.ErrorMessage.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseArea {

    private Long id;

    @NotBlank(message = AREA_NAME_NULL_OR_BLANK)
    @Size(max = 255, message = AREA_NAME_LENGTH_CONSTRAINT)
    private String name;

    private Long productId;

    private String productName;
}
