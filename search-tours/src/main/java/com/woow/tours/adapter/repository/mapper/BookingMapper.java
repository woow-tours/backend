package com.woow.tours.adapter.repository.mapper;

import com.woow.tours.adapter.repository.jpa.entity.booking.BookingTable;
import com.woow.tours.domain.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookingMapper {

    private final UserMapping userMapping;
    private final TourMapper tourMapper;

    public BookingTable toTable(Booking booking) {
        return BookingTable.builder()
                .bookingDateTime(booking.getBookingDateTime())
                .acceptanceTerm(booking.isAcceptanceTerm())
                .quantityOfPeople(booking.getQuantityOfPeople())
                .tour(tourMapper.toEntityWithoutPlaces(booking.getTour()))
                .userTable(userMapping.toTable(booking.getUser()))
                .build();
    }
}
