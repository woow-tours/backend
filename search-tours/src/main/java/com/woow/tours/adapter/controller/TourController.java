package com.woow.tours.adapter.controller;

import com.woow.tours.adapter.controller.DTO.TourDTO;
import com.woow.tours.adapter.controller.mapper.TourMapperDTO;
import com.woow.tours.domain.Tour;
import com.woow.tours.usecase.GetTourByIdUseCase;
import com.woow.tours.usecase.GetToursUseCase;
import com.woow.tours.usecase.SaveTourUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("woow/v1/tours")
@RequiredArgsConstructor
public class TourController {

    private final GetTourByIdUseCase getTourByIdUseCase;
    private final SaveTourUseCase saveTourUseCase;
    private final GetToursUseCase getToursUseCase;
    private final TourMapperDTO tourMapperDTO;

    @PostMapping
    public ResponseEntity save(@RequestBody TourDTO tourDTO) {
        Tour tour = tourMapperDTO.toDomain(tourDTO);
        saveTourUseCase.save(tour);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/all")
    public ResponseEntity getToursByCityId(@RequestParam Long cityId, Pageable pageable) {
        Page tours = getToursUseCase.getToursByCityId(cityId, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(tourMapperDTO.tourResponseDTOPage(tours));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getTourById(@PathVariable Long id) {
        Tour tour = getTourByIdUseCase.getTour(id);
        return ResponseEntity.status(HttpStatus.OK).body(tourMapperDTO.toDTO(tour));
    }
}
