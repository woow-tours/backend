package com.woow.tours.usecase;

import com.woow.tours.domain.Booking;
import com.woow.tours.usecase.port.BookingPort;
import com.woow.tours.usecase.port.TourPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CreateBookingUseCase {

    private static final int MAX_PERIOD_BOOKING = 15;

    private final BookingPort bookingPort;

    private final TourPort tourPort;

    @Transactional
    public void create(Booking booking) {
        long diffbookingDateAndToday = ChronoUnit.DAYS.between(LocalDateTime.now(), booking.getBookingDateTime());

        if (diffbookingDateAndToday > MAX_PERIOD_BOOKING) {
            throw new IllegalArgumentException("O período de reserva não pode ser maior que 15 dias.");
        }

        var tour = tourPort.getById(booking.getTour().getId());
        booking.setCode(UUID.randomUUID().toString());
        booking.setTour(tour);
        bookingPort.save(booking);
    }
}
