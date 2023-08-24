package org.nonit.cashewmanagement.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "outgoing_detail")
public class OutgoingDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "outgoing_amount", nullable = false)
    private Double amount;

    @Column(name = "product_price", nullable = false)
    private Double price;

    private Double discount;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "goodsDeliveryNote_id", nullable = false)
    private GoodsDeliveryNoteEntity goodsDeliveryNote;

    @ManyToOne
    @JoinColumn(name = "incoming_id", nullable = false)
    private IncomingDetailEntity incomingDetail;
}
