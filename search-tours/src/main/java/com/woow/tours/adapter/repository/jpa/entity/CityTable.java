package com.woow.tours.adapter.repository.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "city")
public class CityTable {

    @Id
    @SequenceGenerator(name = "citySquence", sequenceName = "city_sq", initialValue = 1, allocationSize = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "citySequence")
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "city_id")
    private List<PlaceTable> places;

}
