package com.woow.tours.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class City {

    private Long id;

    private String name;

    private List<Place> places;
}
