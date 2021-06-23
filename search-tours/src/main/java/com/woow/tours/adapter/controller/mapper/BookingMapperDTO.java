package com.woow.tours.adapter.controller.mapper;

import com.woow.tours.adapter.controller.DTO.BookingDTO;
import com.woow.tours.domain.Booking;
import com.woow.tours.domain.Tour;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookingMapperDTO {

    private final UserMapperDTO userMapperDTO;

    public Booking toDomain(BookingDTO bookingDTO) {
        return Booking.builder()
                .bookingDateTime(bookingDTO.getBookingDateTime())
                .acceptanceTerm(bookingDTO.isAcceptanceTerm())
                .quantityOfPeople(bookingDTO.getQuantityOfPeople())
                .user(userMapperDTO.toDomain(bookingDTO.getUserDTO()))
                .tour(Tour.builder()
                        .id(bookingDTO.getTourId())
                        .build())
                .build();
    }
}
