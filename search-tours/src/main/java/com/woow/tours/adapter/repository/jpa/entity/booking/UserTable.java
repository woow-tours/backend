package com.woow.tours.adapter.repository.jpa.entity.booking;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserTable {

    @Id
    @SequenceGenerator(name = "userSequence", sequenceName = "user_sq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
    private Long id;

    private String name;

    private String cnpj;

    private String email;

    private String ddd;

    private String phone;

    @Embedded
    private AddressTable address;
}
