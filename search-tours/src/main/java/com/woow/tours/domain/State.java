package com.woow.tours.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class State {

    private Long id;

    private Long code;

    private String name;

    private List<City> cities;
}


