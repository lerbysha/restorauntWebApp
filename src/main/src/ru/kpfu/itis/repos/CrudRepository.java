package ru.kpfu.itis.repos;

import java.util.Optional;

public interface CrudRepository<T, ID> {
    Optional<T> findById(ID id);
    void save(T bean);
    void update(T bean);
    void deleteById(ID id);
    Iterable<T> findAll();
}
