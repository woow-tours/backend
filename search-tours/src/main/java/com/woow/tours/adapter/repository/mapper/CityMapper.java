package com.woow.tours.adapter.repository.mapper;

import com.woow.tours.adapter.repository.jpa.entity.CityTable;
import com.woow.tours.domain.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CityMapper {

    private final PlaceMapper placeMapper;

    public CityTable toEntity(City city) {
        return CityTable.builder()
                .id(city.getId())
                .name(city.getName())
                .places(placeMapper.toEntityList(city.getPlaces()))
                .build();
    }

    public List<CityTable> toEntityList(List<City> cities) {
        return cities.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public City toDomain(CityTable cityTable) {
        return City.builder()
                .id(cityTable.getId())
                .name(cityTable.getName())
                .build();
    }

    public List<City> toDomainList(List<CityTable> citiesTable) {
        return citiesTable.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public City toDomainWithPlaces(CityTable cityTable) {
        return City.builder()
                .id(cityTable.getId())
                .name(cityTable.getName())
                .places(placeMapper.toDomainList(cityTable.getPlaces()))
                .build();
    }
}
