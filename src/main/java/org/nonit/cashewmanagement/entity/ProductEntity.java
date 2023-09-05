package org.nonit.cashewmanagement.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name",unique = true, nullable = false)
    private String name;

    @Column(name = "product_code", unique = true, nullable = false)
    private String code;

    @Column(name = "product_description", length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    private CategoryEnum productCategory;
}
