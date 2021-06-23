package com.woow.tours.adapter.controller.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private Long id;

    private String name;

    private String cnpj;

    private String email;

    private AddressDTO addressDTO;

    private String ddd;

    private String phone;

}

