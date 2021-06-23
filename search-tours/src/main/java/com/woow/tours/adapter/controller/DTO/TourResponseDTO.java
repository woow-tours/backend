package com.woow.tours.adapter.controller.DTO;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class TourResponseDTO {

    private Long id;

    private Long code;

    private String name;

    private String description;

    private String itinerary;

    private String duration;

    private BigDecimal price;

    private List<PlaceDTO> placesDTO;
}
