package com.woow.tours.adapter.repository;

import com.woow.tours.adapter.repository.mapper.UserRegisterMapper;
import com.woow.tours.adapter.repository.jpa.UserRepository;
import com.woow.tours.domain.UserRegister;
import com.woow.tours.usecase.port.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserGateway implements UserPort {

    private final UserRepository userRepository;
    private final UserRegisterMapper userRegisterMapper;

    @Override
    public void save(UserRegister userRegister) {
        userRepository.save(userRegisterMapper.domainToEntity(userRegister));
    }
}
