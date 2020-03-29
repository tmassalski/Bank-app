package com.tmassalski.bankapp.api.user;

import com.tmassalski.bankapp.domain.user.User;
import com.tmassalski.bankapp.domain.user.UserCommand;
import com.tmassalski.bankapp.domain.user.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
class UserController {

    private final UserFacade userFacade;

    @PostMapping("/create")
    void create (@Valid @RequestBody CreateUserRequest request) {
        UserCommand userCommand =  UserCommand.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .login(request.getLogin())
                .password(request.getPassword())
                .build();
        userFacade.createUser(userCommand);
    }

    @GetMapping(value = "/{userId}")
    ResponseEntity<User> findById (@PathVariable long userId) {
        return ResponseEntity.ok(userFacade.getUserById(userId));
    }
}
