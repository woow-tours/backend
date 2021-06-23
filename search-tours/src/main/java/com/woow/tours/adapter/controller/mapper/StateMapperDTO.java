package com.woow.tours.adapter.controller.mapper;

import com.woow.tours.adapter.controller.DTO.StateDTO;
import com.woow.tours.adapter.repository.jpa.entity.StateTable;
import com.woow.tours.domain.City;
import com.woow.tours.domain.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class StateMapperDTO {

    private final CityMapperDTO cityMapperDTO;

    public StateDTO toResponseDTO(State state) {
        return StateDTO.builder()
                .id(state.getId())
                .code(state.getCode())
                .name(state.getName())
                .build();
    }

    public StateDTO toCompleteResponseDTO(State state) {
        return StateDTO.builder()
                .id(state.getId())
                .code(state.getCode())
                .name(state.getName())
                .cities(cityMapperDTO.toResponseDTOList(state.getCities()))
                .build();
    }

    public List<StateDTO> toResponseDTOList(List<State> states) {
        return states.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public State toDomain(StateDTO stateDTO) {
        return State.builder()
                .id(stateDTO.getId())
                .name(stateDTO.getName())
                .code(stateDTO.getCode())
                .cities(cityMapperDTO.toDomainList(stateDTO.getCities()))
                .build();
    }

    public List<State> toDomainList(List<StateDTO> stateDTOS) {
        return stateDTOS.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}
