package com.woow.tours.adapter.repository.jpa.entity.booking;

import com.woow.tours.adapter.repository.jpa.entity.TourTable;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class BookingTable {

    @Id
    @SequenceGenerator(name = "bookingSquence", sequenceName = "booking_sq", initialValue = 1, allocationSize = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingSequence")
    private Long id;

    private String protocolCode;

    private LocalDateTime bookingDateTime;

    private int quantityOfPeople;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private UserTable userTable;

    @OneToOne
    private TourTable tour;

    private boolean acceptanceTerm;
}
