package com.tmassalski.bankapp.infrastructure.user;

import com.tmassalski.bankapp.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
