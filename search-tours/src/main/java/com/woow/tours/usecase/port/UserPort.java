package com.woow.tours.usecase.port;

import com.woow.tours.domain.UserRegister;

public interface UserPort {

    void save(UserRegister userRegister);
}
