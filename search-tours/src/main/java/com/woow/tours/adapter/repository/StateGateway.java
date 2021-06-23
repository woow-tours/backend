package com.woow.tours.adapter.repository;

import com.woow.tours.adapter.repository.jpa.StateRepository;
import com.woow.tours.adapter.repository.jpa.entity.StateTable;
import com.woow.tours.adapter.repository.mapper.StateMapper;
import com.woow.tours.domain.State;
import com.woow.tours.usecase.port.StatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StateGateway implements StatePort {

    private final StateRepository stateRepository;
    private final StateMapper mapper;

    public List<State> getAll() {
        return mapper.toDomainList(stateRepository.findAll());
    }

    @Override
    public void save(State state)  {
        Optional<StateTable> stateByCode = stateRepository.findByCode(state.getCode());
        if (stateByCode.isPresent()) {
            state.setId(stateByCode.get().getId());
        }
        StateTable stateTable = mapper.toEntity(state);
        stateRepository.save(stateTable);
    }

    @Override
    public State getById(Long stateId) {
        return mapper.toDomain(stateRepository.getState(stateId).get());
    }
}
