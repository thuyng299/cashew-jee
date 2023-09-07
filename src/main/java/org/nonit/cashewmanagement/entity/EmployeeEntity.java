package org.nonit.cashewmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @Column(name = "employee_address", nullable = false)
    private String address;

    @Column(nullable = false)
    private Double salary;

    @Column(name = "employee_position", nullable = false)
    private String position;

    @Column(name = "employee_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @Column(name = "assigned_date")
    private LocalDateTime assignedDate;

    @Column(name = "modified_date")
    private LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private WarehouseAreaEntity warehouseArea;
}
