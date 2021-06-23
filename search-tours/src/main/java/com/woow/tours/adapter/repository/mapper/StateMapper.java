package com.woow.tours.adapter.repository.mapper;

import com.woow.tours.adapter.repository.jpa.entity.StateTable;
import com.woow.tours.domain.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class StateMapper {

    private final CityMapper cityMapper;

    public State toDomain(StateTable stateTable) {
        return State.builder()
                .id(stateTable.getId())
                .code(stateTable.getCode())
                .name(stateTable.getName())
                .cities(cityMapper.toDomainList(stateTable.getCities()))
                .build();
    }

    public List<State> toDomainList(List<StateTable> statesTable) {
        return statesTable.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public StateTable toEntity(State state) {
        return StateTable.builder()
                .id(state.getId())
                .code(state.getCode())
                .name(state.getName())
                .cities(cityMapper.toEntityList(state.getCities()))
                .build();
    }
}
