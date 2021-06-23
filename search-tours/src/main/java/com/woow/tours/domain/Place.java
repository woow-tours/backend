package com.woow.tours.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Place {

    private Long id;

    private String name;

    private String description;

    private City city;

    private Tour tour;
}
