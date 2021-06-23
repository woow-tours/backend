package com.woow.tours.adapter.repository;

import com.woow.tours.adapter.repository.jpa.CityRepository;
import com.woow.tours.adapter.repository.jpa.StateRepository;
import com.woow.tours.adapter.repository.jpa.entity.CityTable;
import com.woow.tours.adapter.repository.mapper.CityMapper;
import com.woow.tours.domain.City;
import com.woow.tours.usecase.port.CityPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CityGateway implements CityPort {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;
    private final StateRepository stateRepository;

    @Override
    public List<City> getCitiesByStateId(Long stateId) {
        return cityMapper.toDomainList(stateRepository.findById(stateId).get().getCities());
    }

    @Override
    public City getById(Long id) {
        Optional<CityTable> city = cityRepository.findById(id);

        if (!city.isPresent()) {
            throw new NotFoundInDataBaseException();
        }

        return cityMapper.toDomainWithPlaces(city.get());
    }
}
