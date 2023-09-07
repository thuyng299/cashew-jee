package org.nonit.cashewmanagement.service.model;

import lombok.*;
import org.nonit.cashewmanagement.entity.CategoryEnum;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockAmountOfCategoryStat {

    private Long productId;

    private String productCode;

    private CategoryEnum productCategory;

    private Double totalStockAmount;
}
