package org.nonit.cashewmanagement.service.model;

import lombok.*;
import org.nonit.cashewmanagement.entity.CategoryEnum;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private Long id;

    private String name;

    private String code;

    private String description;

    private CategoryEnum productCategory;
}
