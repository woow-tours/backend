package com.woow.tours.adapter.controller;

import com.woow.tours.adapter.controller.DTO.StateDTO;
import com.woow.tours.adapter.controller.mapper.StateMapperDTO;
import com.woow.tours.usecase.GetAllStateUseCase;
import com.woow.tours.usecase.GetStateUseCase;
import com.woow.tours.usecase.SaveStateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("woow/v1/states")
@RequiredArgsConstructor
public class StateController {

    private final SaveStateUseCase saveStateUseCase;
    private final GetAllStateUseCase getAllStateUseCase;
    private final GetStateUseCase getStateUseCase;
    private final StateMapperDTO mapper;

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody StateDTO state) {
        saveStateUseCase.save(mapper.toDomain(state));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<StateDTO>> getAllStates() {
        List<StateDTO> statesDTO = mapper.toResponseDTOList(getAllStateUseCase.getAll());
        return ResponseEntity.ok(statesDTO);
    }

    @GetMapping(path = "{stateId}/cities")
    public ResponseEntity<StateDTO> getCitiesByState(@PathVariable Long stateId) {
        StateDTO stateDTO = mapper.toCompleteResponseDTO(getStateUseCase.getCitiesByStateId(stateId));
        return ResponseEntity.ok(stateDTO);
    }
}
