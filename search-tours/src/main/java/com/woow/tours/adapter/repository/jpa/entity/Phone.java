package com.woow.tours.adapter.repository.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Phone {

    @Id
    @SequenceGenerator(name = "phoneSquence", sequenceName = "phone_sq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phoneSequence")
    private Long id;

    private String prefix;

    private String suffix;
}
