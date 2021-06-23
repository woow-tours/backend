package com.woow.tours.usecase.port;

import com.woow.tours.domain.State;

import java.util.List;

public interface StatePort {

    List<State> getAll();

    void save(State state);

    State getById(Long stateId);
}
