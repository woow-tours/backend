package com.woow.tours.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Booking {

    private Long id;

    private String code;

    private LocalDateTime bookingDateTime;

    private int quantityOfPeople;

    private User user;

    private boolean acceptanceTerm;

    private BigDecimal price;

    private Tour tour;

}
