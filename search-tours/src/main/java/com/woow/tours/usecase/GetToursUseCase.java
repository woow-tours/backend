package com.woow.tours.usecase;

import com.woow.tours.domain.City;
import com.woow.tours.domain.Place;
import com.woow.tours.domain.Tour;
import com.woow.tours.usecase.port.CityPort;
import com.woow.tours.usecase.port.TourPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetToursUseCase {

    private final CityPort cityPort;
    private final TourPort tourPort;

    public Page<Tour> getToursByCityId(Long cityId, Pageable pageable) {
        City city = cityPort.getById(cityId);
        List<Long> ids = city.getPlaces().stream()
                .map(Place::getId)
                .collect(Collectors.toList());

        return tourPort.getTours(ids, pageable);
    }
}
