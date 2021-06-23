package com.woow.tours.usecase;

import com.woow.tours.domain.UserRegister;
import com.woow.tours.usecase.port.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateUserRegister {

    private final UserPort userPort;

    public void create(UserRegister userRegister) {
        userPort.save(userRegister);
    }
}

