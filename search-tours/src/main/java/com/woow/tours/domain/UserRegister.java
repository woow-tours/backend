package com.woow.tours.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@Builder
public class UserRegister {

    private String email;

    private String password;

    public String getPassword() {
        return new BCryptPasswordEncoder().encode(password);
    }
}
