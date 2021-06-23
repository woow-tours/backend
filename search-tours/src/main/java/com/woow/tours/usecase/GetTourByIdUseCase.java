package com.woow.tours.usecase;

import com.woow.tours.domain.Tour;
import com.woow.tours.usecase.port.TourPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetTourByIdUseCase {

    private final TourPort tourPort;

    public Tour getTour(Long id) {
        return tourPort.getById(id);
    }
}
