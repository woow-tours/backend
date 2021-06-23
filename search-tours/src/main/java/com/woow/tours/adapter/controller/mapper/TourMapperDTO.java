package com.woow.tours.adapter.controller.mapper;

import com.woow.tours.adapter.controller.DTO.TourDTO;
import com.woow.tours.adapter.controller.DTO.TourResponseDTO;
import com.woow.tours.domain.Tour;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TourMapperDTO {

    private final PlaceMapperDTO placeMapperDTO;

    public Tour toDomain(TourDTO tourDTO) {
        return Tour.builder()
                .id(tourDTO.getId())
                .code(tourDTO.getCode())
                .name(tourDTO.getName())
                .description(tourDTO.getDescription())
                .duration(tourDTO.getDuration())
                .itinerary(tourDTO.getItinerary())
                .price(tourDTO.getPrice())
                .places(placeMapperDTO.toDomainList(tourDTO.getPlacesDTO()))
                .build();
    }

    public TourResponseDTO toDTO(Tour tour) {
        return TourResponseDTO.builder()
                .id(tour.getId())
                .code(tour.getCode())
                .name(tour.getName())
                .description(tour.getDescription())
                .duration(tour.getDuration())
                .itinerary(tour.getItinerary())
                .price(tour.getPrice())
                .placesDTO(placeMapperDTO.toDTOList(tour.getPlaces()))
                .build();
    }

    public Page<TourResponseDTO> tourResponseDTOPage(Page<Tour> tours) {
        return tours.map(this::toDTO);
    }
}
