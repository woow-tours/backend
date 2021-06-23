package com.woow.tours.adapter.controller.mapper;

import com.woow.tours.adapter.controller.DTO.PlaceDTO;
import com.woow.tours.adapter.repository.jpa.entity.PlaceTable;
import com.woow.tours.domain.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PlaceMapperDTO {

    public Place toDomain(PlaceDTO placeDTO) {
        return Place.builder()
                .id(placeDTO.getId())
                .name(placeDTO.getName())
                .description(placeDTO.getDescription())
                .build();
    }

    public List<Place> toDomainList(List<PlaceDTO> places) {
        if (places == null) {
            return null;
        }
        return places.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public PlaceDTO toDTO(Place place) {
        return PlaceDTO.builder()
                .id(place.getId())
                .name(place.getName())
                .description(place.getDescription())
                .build();
    }

    public List<PlaceDTO> toDTOList(List<Place> places) {
        if (places == null) {
            return null;
        }
        return places.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
