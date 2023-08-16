package org.nonit.cashewmanagement.service.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseArea {

    private Long id;

    private String name;

    private Long productId;

    private String productName;
}
