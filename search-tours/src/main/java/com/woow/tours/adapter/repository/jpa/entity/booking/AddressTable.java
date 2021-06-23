package com.woow.tours.adapter.repository.jpa.entity.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@Embeddable
public class AddressTable {

    private String cep;

    private String street;

    private String number;

    private String complement;

    private String city;

    private String state;
}
