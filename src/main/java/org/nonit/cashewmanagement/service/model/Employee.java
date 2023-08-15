package org.nonit.cashewmanagement.service.model;

import lombok.*;
import org.nonit.cashewmanagement.entity.RoleEnum;
import org.nonit.cashewmanagement.entity.StatusEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    private Long id;

    private String firstName;

    private String lastName;

    private String gender;

    private String email;

    private String phone;

    private LocalDate hireDate;

    private String address;

    private Double salary;

    private String position;

    private StatusEnum status;

    private String username;

    private String password;

    private RoleEnum role;

    private LocalDateTime assignedDate;

    private LocalDateTime updatedDate;
}
