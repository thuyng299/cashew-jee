package org.nonit.cashewmanagement.service.model;

import lombok.*;
import org.nonit.cashewmanagement.entity.CategoryEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static org.nonit.cashewmanagement.utils.exception.ErrorMessage.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private Long id;

    @NotBlank(message = PRODUCT_NAME_NULL_OR_BLANK)
    @Size(min = 5, max = 50, message = PRODUCT_NAME_LENGTH_CONSTRAINT)
    private String name;

    @NotBlank(message = PRODUCT_CODE_NULL_OR_BLANK)
    @Size(max = 10, message = PRODUCT_CODE_LENGTH_CONSTRAINT)
    private String code;

    @Size(max = 1000, message = PRODUCT_DESCRIPTION_LENGTH_CONSTRAINT)
    private String description;

    @Enumerated(EnumType.STRING)
    private CategoryEnum productCategory;
}
