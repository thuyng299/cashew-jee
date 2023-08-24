package org.nonit.cashewmanagement.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false, unique = true)
    private String name;

    @Column(name = "customer_code", nullable = false, unique = true)
    private String code;

    @Column(name = "customer_address")
    private String address;

    @Column(name = "customer_email", nullable = false,unique = true)
    private String email;

    @Column(name = "customer_phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEnum status;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private CountryEntity country;
}
