package com.diplomski.backend.repository;

import com.diplomski.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    UserDetails findByEmail(String email);

    Optional<UserDetails> findByEmailNew(String email);
}
