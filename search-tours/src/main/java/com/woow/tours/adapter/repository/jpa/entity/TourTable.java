package com.woow.tours.adapter.repository.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tour")
public class TourTable {

    @Id
    @SequenceGenerator(name = "tourSquence", sequenceName = "tour_sq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tourSequence")
    private Long id;

    @Column(unique = true)
    private Long code;

    private String name;

    private String description;

    private String itinerary;

    private String duration;

    private BigDecimal price;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "place_tours",
            joinColumns = @JoinColumn(name = "tours_id"),
            inverseJoinColumns = @JoinColumn(name = "place_id"))
    private List<PlaceTable> places;
}
