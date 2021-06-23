package com.woow.tours.usecase;

import com.woow.tours.domain.State;
import com.woow.tours.usecase.port.StatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAllStateUseCase {

    private final StatePort statePort;

    public List<State> getAll() {
        return statePort.getAll();
    }
}
