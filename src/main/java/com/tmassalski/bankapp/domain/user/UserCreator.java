package com.tmassalski.bankapp.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class UserCreator {

    private final CreateUserClient createUserClient;

    @Transactional
    void createUser(UserCommand userCommand) {
        User user = User.generate(userCommand);
        createUserClient.create(user);
    }
}
