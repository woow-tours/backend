package com.woow.tours.adapter.controller.mapper;

import com.woow.tours.adapter.controller.DTO.UserRegisterDTO;
import com.woow.tours.domain.UserRegister;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterMapperDTO {

    public UserRegister dtoToDomain(UserRegisterDTO userRegisterDTO) {
        return UserRegister.builder()
                .email(userRegisterDTO.getEmail())
                .password(userRegisterDTO.getPassword())
                .build();
    }
}
