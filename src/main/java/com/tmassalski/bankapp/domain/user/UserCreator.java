package com.tmassalski.bankapp.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserCreator {

   private final CreateUserClient createUserClient;

    void create (UserCommand userCommand) {
        User user = User.generate(userCommand);
        createUserClient.create(user);
    }
}
