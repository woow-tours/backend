package com.woow.tours.adapter.controller.DTO;

import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class StateDTO {

    private Long id;

    @NotNull(message = "o campo code não pode ser nulo")
    private Long code;

    @NotNull(message = "o campo code não pode ser nulo")
    @NotBlank(message = "o campo code não pode ser vazio")
    private String name;

    @Valid
    private List<CityDTO> cities;
}
