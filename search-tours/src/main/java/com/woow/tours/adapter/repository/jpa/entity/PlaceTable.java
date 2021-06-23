package com.woow.tours.adapter.repository.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "place")
public class PlaceTable {

    @Id
    @SequenceGenerator(name = "placeSequence", sequenceName = "place_sq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "placeSequence")
    private Long id;

    private String name;

    //private List<TourPhoto> tourPhotos;

    private String description;

    private String observation;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "places", cascade = CascadeType.PERSIST)
    private List<TourTable> tours;

}
