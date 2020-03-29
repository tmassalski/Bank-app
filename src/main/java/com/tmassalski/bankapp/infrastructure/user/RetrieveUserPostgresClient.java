package com.tmassalski.bankapp.infrastructure.user;

import com.tmassalski.bankapp.domain.user.User;
import com.tmassalski.bankapp.domain.user.UserException;
import com.tmassalski.bankapp.domain.user.UserRetrievalClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RetrieveUserPostgresClient implements UserRetrievalClient {

    private final UserRepository userRepository;

    @Override
    public User getById(long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElseThrow(
                () -> UserException.userIdNotFound(userId));
    }
}
