package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Product;
import ru.kpfu.itis.repos.ProductRepository;
import ru.kpfu.itis.repos.ProductRepositoryImpl;

import java.util.List;

public class MenuService {
    private ProductRepository productRepository = new ProductRepositoryImpl();
    public List<Product> getMenu(){
        return (List<Product>) productRepository.findAll();
    }
}
