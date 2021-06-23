package com.woow.tours.adapter.controller.DTO;

import com.woow.tours.adapter.repository.jpa.entity.PlaceTable;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class TourDTO {

    private Long id;

    private Long code;

    private String name;

    private String description;

    private String itinerary;

    private String duration;

    private BigDecimal price;

    private List<PlaceDTO> placesDTO;
}
