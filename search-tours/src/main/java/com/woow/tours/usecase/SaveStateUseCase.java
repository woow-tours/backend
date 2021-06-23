package com.woow.tours.usecase;

import com.woow.tours.domain.State;
import com.woow.tours.usecase.port.StatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveStateUseCase {

    private final StatePort statePort;

    public void save(State states) {
        statePort.save(states);
    }
}
