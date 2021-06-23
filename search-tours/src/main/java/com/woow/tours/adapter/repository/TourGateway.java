package com.woow.tours.adapter.repository;

import com.woow.tours.adapter.repository.jpa.PlaceRepository;
import com.woow.tours.adapter.repository.jpa.TourRepository;
import com.woow.tours.adapter.repository.jpa.entity.PlaceTable;
import com.woow.tours.adapter.repository.jpa.entity.TourTable;
import com.woow.tours.adapter.repository.mapper.TourMapper;
import com.woow.tours.domain.Place;
import com.woow.tours.domain.Tour;
import com.woow.tours.usecase.port.TourPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class TourGateway implements TourPort {

    private final PlaceRepository placeRepository;
    private final TourRepository tourRepository;
    private final TourMapper mapper;

    @Override
    @Transactional
    public void save(Tour tour) {
        List<Long> ids = tour.getPlaces().stream()
                .map(Place::getId)
                .collect(Collectors.toList());
        List<PlaceTable> placesTable = placeRepository.findPlacesById(ids);

        Optional<TourTable> tourFoundDB = tourRepository.findByCode(tour.getCode());

        TourTable tourTable;

        if (tourFoundDB.isPresent()) {
            tourTable = tourFoundDB.get();
            tour.setId(tourTable.getId());
        }

        TourTable tourTableToSave = mapper.toEntity(tour);
        tourTableToSave.setPlaces(placesTable);

        tourRepository.save(tourTableToSave);
    }

    @Override
    public Page<Tour> getTours(List<Long> placesId, Pageable pageable) {
        Page<TourTable> toursTable = tourRepository.findByPLacesId(placesId, pageable);
        return mapper.toDomainList(toursTable);
    }

    @Override
    public Tour getById(Long id) {
        TourTable tourTable = tourRepository.findById(id).orElseThrow(NotFoundInDataBaseException::new);
        return mapper.toDomainWithPlaces(tourTable);
    }
}
