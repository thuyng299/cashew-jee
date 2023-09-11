package org.nonit.cashewmanagement.service.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CostStat {

    private Long productId;

    private String productName;

    private Double totalAmount;

    private Double totalCost;
}
