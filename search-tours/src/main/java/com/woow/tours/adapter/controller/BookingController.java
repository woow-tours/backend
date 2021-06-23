package com.woow.tours.adapter.controller;

import com.woow.tours.adapter.controller.DTO.BookingDTO;
import com.woow.tours.adapter.controller.mapper.BookingMapperDTO;
import com.woow.tours.usecase.CreateBookingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/woow/v1/bookings")
public class BookingController {

    private final CreateBookingUseCase createBookingUseCase;
    private final BookingMapperDTO bookingMapperDTO;

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody BookingDTO bookingDTO) {
        createBookingUseCase.create(bookingMapperDTO.toDomain(bookingDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
