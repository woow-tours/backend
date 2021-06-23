package com.woow.tours.adapter.controller.mapper;


import com.woow.tours.adapter.controller.DTO.AddressDTO;
import com.woow.tours.adapter.controller.DTO.UserDTO;
import com.woow.tours.domain.Address;
import com.woow.tours.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperDTO {

    public User toDomain(UserDTO userDTO) {
        AddressDTO addressDTO = userDTO.getAddressDTO();
        Address address = Address.builder()
                .cep(addressDTO.getCep())
                .street(addressDTO.getStreet())
                .number(addressDTO.getNumber())
                .complement(addressDTO.getComplement())
                .city(addressDTO.getCity())
                .state(addressDTO.getState())
                .build();
        return User.builder()
                .address(address)
                .cnpj(userDTO.getCnpj())
                .email(userDTO.getEmail())
                .name(userDTO.getName())
                .ddd(userDTO.getDdd())
                .phone(userDTO.getPhone())
                .build();
    }
}
