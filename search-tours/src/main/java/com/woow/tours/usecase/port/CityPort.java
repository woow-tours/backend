package com.woow.tours.usecase.port;

import com.woow.tours.domain.City;

import java.util.List;

public interface CityPort {

    List<City> getCitiesByStateId(Long stateId);

    City getById(Long id);

}
