package com.woow.tours.adapter.controller;

import com.woow.tours.adapter.controller.DTO.UserRegisterDTO;
import com.woow.tours.adapter.controller.mapper.UserRegisterMapperDTO;
import com.woow.tours.usecase.CreateUserRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/woow/v1/user-register")
public class UserRegisterController {

    private final CreateUserRegister createUserRegister;
    private final UserRegisterMapperDTO userRegisterMapperDTO;

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody UserRegisterDTO userRegisterDTO) {
        createUserRegister.create(userRegisterMapperDTO.dtoToDomain(userRegisterDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
