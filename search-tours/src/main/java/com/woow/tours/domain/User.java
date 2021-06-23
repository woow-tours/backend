package com.woow.tours.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Long id;

    private String name;

    private String cnpj;

    private String email;

    private Address address;

    private String ddd;

    private String phone;
}
