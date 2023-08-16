package org.nonit.cashewmanagement.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "supplier")
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "supplier_name", nullable = false, unique = true)
    private String name;

    @Column(name = "supplier_code", nullable = false, unique = true, length = 10)
    private String code;

    @Column(name = "supplier_address")
    private String address;

    @Column(name = "supplier_email", nullable = false,unique = true)
    private String email;

    @Column(name = "supplier_phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEnum status;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private CountryEntity country;
}
