package com.woow.tours.adapter.repository.mapper;

import com.woow.tours.adapter.repository.jpa.entity.booking.AddressTable;
import com.woow.tours.adapter.repository.jpa.entity.booking.UserTable;
import com.woow.tours.domain.Address;
import com.woow.tours.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapping {

    public UserTable toTable(User user) {
        Address address = user.getAddress();
        AddressTable addressTable = AddressTable.builder()
                .cep(address.getCep())
                .street(address.getStreet())
                .number(address.getNumber())
                .complement(address.getComplement())
                .city(address.getCity())
                .state(address.getState())
                .build();

        return UserTable.builder()
                .address(addressTable)
                .cnpj(user.getCnpj())
                .email(user.getEmail())
                .name(user.getName())
                .ddd(user.getDdd())
                .phone(user.getPhone())
                .build();
    }
}
