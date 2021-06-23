package com.woow.tours.adapter.controller.mapper;

import com.woow.tours.adapter.controller.DTO.CityDTO;
import com.woow.tours.adapter.repository.jpa.entity.CityTable;
import com.woow.tours.domain.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CityMapperDTO {

    private final PlaceMapperDTO placeMapper;

    public City toDomain(CityDTO cityDTO) {
        return City.builder()
                .id(cityDTO.getId())
                .name(cityDTO.getName())
                .places(placeMapper.toDomainList(cityDTO.getPlacesDTO()))
                .build();
    }

    public List<City> toDomainList(List<CityDTO> cities) {
        return cities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public CityDTO toResponseDTO(City city) {
        return CityDTO.builder()
                .id(city.getId())
                .name(city.getName())
                .build();
    }

    public List<CityDTO> toResponseDTOList(List<City> cities) {
        return cities.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
