package com.woow.tours.adapter.repository.jpa.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
public class UserTravel {

    @Id
    @SequenceGenerator(name = "userTravelSquence", sequenceName = "userTravel_sq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userTravelSquence")
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String email;

    private String phone;

    private String cpf;
}
