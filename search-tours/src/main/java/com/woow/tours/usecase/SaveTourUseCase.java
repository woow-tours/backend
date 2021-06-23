package com.woow.tours.usecase;

import com.woow.tours.domain.Tour;
import com.woow.tours.usecase.port.TourPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SaveTourUseCase {

    private final TourPort tourPort;

    public void save(Tour tour) {
        tourPort.save(tour);
    }
}
