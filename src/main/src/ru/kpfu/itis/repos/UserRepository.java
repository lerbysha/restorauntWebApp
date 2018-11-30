package ru.kpfu.itis.repos;

import ru.kpfu.itis.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    Optional<User> findByToken(String token);
}
