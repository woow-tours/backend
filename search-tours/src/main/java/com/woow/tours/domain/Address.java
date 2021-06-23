package com.woow.tours.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    private Long id;

    private String cep;

    private String street;

    private String number;

    private String complement;

    private String city;

    private String state;
}
