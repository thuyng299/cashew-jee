//package org.nonit.cashewmanagement.entity;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Table(name = "goods_delivery_note")
//public class GoodsDeliveryNoteEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "gdn_code", unique = true, nullable = false)
//    private String code;
//
//    @Column(name = "outgoing_date", nullable = false)
//    private LocalDateTime outgoingDate;
//
//    @Column(name = "gdn_record", length = 500)
//    private String record;
//
//    @ManyToOne
//    @JoinColumn(name = "employee_id", nullable = false)
//    private EmployeeEntity employee;
//
//    @ManyToOne
//    @JoinColumn(name = "customer_id", nullable = false)
//    private CustomerEntity customer;
//
////    @OneToMany(mappedBy = "goodsDeliveryNote", cascade = CascadeType.ALL)
////    private List<OutgoingDetailEntity> outgoingDetail;
//}
