package com.woow.tours.adapter.repository;

import com.woow.tours.adapter.repository.jpa.BookingRepository;
import com.woow.tours.adapter.repository.mapper.BookingMapper;
import com.woow.tours.domain.Booking;
import com.woow.tours.usecase.port.BookingPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class BookingGateway implements BookingPort {

    private final BookingRepository bookingRepository;

    private final BookingMapper bookingMapper;
    
    public void save(Booking booking) {
        bookingRepository.save(bookingMapper.toTable(booking));
    }

    public Optional<Booking> getByProtocolCode(String protocolCode) {
        return Optional.empty();
    }
}
