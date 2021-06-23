package com.woow.tours.adapter.controller.DTO;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class UserRegisterDTO {

    @NotNull
    @Pattern(regexp=".+@.+\\.[a-z]+", message="Invalid email address!")
    private String email;

    private String password;
}
