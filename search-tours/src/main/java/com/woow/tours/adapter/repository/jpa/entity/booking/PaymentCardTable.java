package com.woow.tours.adapter.repository.jpa.entity.booking;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paymentCard")
public class PaymentCardTable {

    @Id
    @SequenceGenerator(name = "paymentCardSquence", sequenceName = "paymentCard_sq", initialValue = 1, allocationSize = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentCardSequence")
    private Long id;

    private String number;

    private String cardUserName;

    @OneToOne
    private UserTable user;
}
