package com.woow.tours.usecase;

import com.woow.tours.domain.State;
import com.woow.tours.usecase.port.StatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetStateUseCase {

    private final StatePort statePort;

    public State getCitiesByStateId(Long stateId) {
        return statePort.getById(stateId);
    }
}
