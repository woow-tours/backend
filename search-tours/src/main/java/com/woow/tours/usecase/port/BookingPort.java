package com.woow.tours.usecase.port;

import com.woow.tours.domain.Booking;

import java.util.Optional;

public interface BookingPort {

    void save(Booking booking);

    Optional<Booking> getByProtocolCode(String protocolCode);
}
