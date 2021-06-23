package com.woow.tours.adapter.repository.jpa;

import com.woow.tours.adapter.repository.jpa.entity.booking.BookingTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<BookingTable, Long> {

    //@Query(value = "select b booking b join booking.user u where b.protocolCode = :protocolCode")
    Optional<BookingTable> getBookingByProtocolCode(@Param("protocolCode") String protocolCode);
}
