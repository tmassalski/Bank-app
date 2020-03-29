package com.tmassalski.bankapp.infrastructure.user;

import com.tmassalski.bankapp.domain.user.CreateUserClient;
import com.tmassalski.bankapp.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserPostgresClient implements CreateUserClient {

    private final UserRepository userRepository;

    @Override
    public void create(User user) {
        userRepository.save(user);
    }
}
