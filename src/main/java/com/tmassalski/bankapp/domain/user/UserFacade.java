package com.tmassalski.bankapp.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserCreator userCreator;
    private final UserRetrievalClient userRetrievalClient;

    public void createUser(UserCommand userCommand){
        userCreator.createUser(userCommand);
    }

    public User getUserById(Long userId) {
        return userRetrievalClient.getById(userId);
    }
}
