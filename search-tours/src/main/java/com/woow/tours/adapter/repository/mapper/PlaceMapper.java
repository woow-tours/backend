package com.woow.tours.adapter.repository.mapper;

import com.woow.tours.adapter.repository.jpa.entity.CityTable;
import com.woow.tours.adapter.repository.jpa.entity.PlaceTable;
import com.woow.tours.domain.City;
import com.woow.tours.domain.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PlaceMapper {

    public PlaceTable toEntity(Place place) {
        return PlaceTable.builder()
                .id(place.getId())
                .name(place.getName())
                .description(place.getDescription())
                .build();
    }

    public List<PlaceTable> toEntityList(List<Place> places) {
        return places.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public Place toDomain(PlaceTable placeTable) {
        return Place.builder()
                .id(placeTable.getId())
                .name(placeTable.getName())
                .description(placeTable.getDescription())
                .build();
    }

    public List<Place> toDomainList(List<PlaceTable> places) {
        return places.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}
