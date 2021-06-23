package com.woow.tours.adapter.controller.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {

    private Long id;

    private String cep;

    private String street;

    private String number;

    private String complement;

    private String city;

    private String state;
}
