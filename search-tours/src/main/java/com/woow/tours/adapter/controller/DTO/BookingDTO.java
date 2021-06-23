package com.woow.tours.adapter.controller.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BookingDTO {

    private LocalDateTime bookingDateTime;

    private int quantityOfPeople;

    private UserDTO userDTO;

    private Long tourId;

    private boolean acceptanceTerm;
}
