package org.nonit.cashewmanagement.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "goods_received_note")
public class GoodsReceivedNoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "grn_code", unique = true, nullable = false)
    private String code;

    @Column(name = "incoming_date", nullable = false)
    private LocalDateTime incomingDate;

    @Column(name = "grn_record", length = 500)
    private String record;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employee;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private SupplierEntity supplier;

}
