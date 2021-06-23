package com.woow.tours.usecase.port;

import com.woow.tours.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TourPort {

    void save(Tour tour);

    Page<Tour> getTours(List<Long> placesId, Pageable pageable);

    Tour getById(Long id);
}
