package com.woow.tours.adapter.repository.mapper;

import com.woow.tours.adapter.repository.jpa.entity.Login;
import com.woow.tours.domain.UserRegister;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterMapper {

    public Login domainToEntity(UserRegister userRegister) {
        return Login.builder()
                .username(userRegister.getEmail())
                .password(userRegister.getPassword())
                .build();
    }
}
