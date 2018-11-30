package ru.kpfu.itis.repos;


import ru.kpfu.itis.model.Product;
import ru.kpfu.itis.repos.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
