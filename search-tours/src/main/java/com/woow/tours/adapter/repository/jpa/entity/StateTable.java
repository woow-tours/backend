package com.woow.tours.adapter.repository.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NamedEntityGraph(
        name = "state-graph",
        attributeNodes = {@NamedAttributeNode("cities")}
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "state", schema = "woow")
public class StateTable {

    @Id
    @SequenceGenerator(name = "stateSquence", sequenceName = "state_sq", initialValue = 1, allocationSize = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stateSequence")
    private Long id;

    @Column(unique = true)
    private Long code;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "state_id")
    private List<CityTable> cities;
}
