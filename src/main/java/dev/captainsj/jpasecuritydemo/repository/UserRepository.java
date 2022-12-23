package dev.captainsj.jpasecuritydemo.repository;

import dev.captainsj.jpasecuritydemo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);
}


