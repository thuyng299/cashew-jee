package org.nonit.cashewmanagement.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "warehouse_area")
public class WarehouseAreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "area_name", nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
}
