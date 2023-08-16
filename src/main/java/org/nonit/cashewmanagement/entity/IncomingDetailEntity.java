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
@Table(name = "incoming_detail")
public class IncomingDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "incoming_amount", nullable = false)
    private Double amount;

    @Column(name = "product_cost", nullable = false)
    private Double cost;

    @Column(name = "remaining_amount")
    private Double remainingAmount;

    @Column(name = "expiration_date", nullable = false)
    private LocalDateTime expirationDate;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private WarehouseAreaEntity warehouseArea;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private GoodsReceivedNoteEntity goodsReceivedNote;
}
