package com.woow.tours.adapter.controller.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaceDTO {

    private Long id;

    private String name;

    private String description;
}
