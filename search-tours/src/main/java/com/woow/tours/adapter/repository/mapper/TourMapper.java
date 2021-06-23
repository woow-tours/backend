package com.woow.tours.adapter.repository.mapper;

import com.woow.tours.adapter.repository.jpa.entity.PlaceTable;
import com.woow.tours.adapter.repository.jpa.entity.TourTable;
import com.woow.tours.domain.Tour;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TourMapper {

    private final PlaceMapper placeMapper;

    public TourTable toEntity(Tour tour) {
        return TourTable.builder()
                .id(tour.getId())
                .code(tour.getCode())
                .name(tour.getName())
                .duration(tour.getDuration())
                .itinerary(tour.getItinerary())
                .price(tour.getPrice())
                .places(placeMapper.toEntityList(tour.getPlaces()))
                .build();
    }

    public TourTable toEntityWithoutPlaces(Tour tour) {
        return TourTable.builder()
                .id(tour.getId())
                .code(tour.getCode())
                .name(tour.getName())
                .duration(tour.getDuration())
                .itinerary(tour.getItinerary())
                .price(tour.getPrice())
                .build();
    }

    public Tour toDomain(TourTable tourTable) {
        return Tour.builder()
                .id(tourTable.getId())
                .code(tourTable.getCode())
                .name(tourTable.getName())
                .itinerary(tourTable.getItinerary())
                .price(tourTable.getPrice())
                .description(tourTable.getDescription())
                .duration(tourTable.getDuration())
                .build();
    }

    public Tour toDomainWithPlaces(TourTable tourTable) {
        return Tour.builder()
                .id(tourTable.getId())
                .code(tourTable.getCode())
                .name(tourTable.getName())
                .itinerary(tourTable.getItinerary())
                .description(tourTable.getDescription())
                .duration(tourTable.getDuration())
                .price(tourTable.getPrice())
                .places(placeMapper.toDomainList(tourTable.getPlaces()))
                .build();
    }

    public Page<Tour> toDomainList(Page<TourTable> tourTable) {
        return tourTable.map(this::toDomain);
    }
}
