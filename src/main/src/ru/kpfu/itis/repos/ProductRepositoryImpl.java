package ru.kpfu.itis.repos;


import ru.kpfu.itis.model.Product;
import ru.kpfu.itis.util.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {
Connection connection = DatabaseManager.getDataSource();
    @Override
    public Optional<Product> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void save(Product bean) {

    }

    @Override
    public void update(Product bean) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Iterable<Product> findAll() {
        String sql = "select * from product;";
        try {
            PreparedStatement pstm =connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            List<Product> products =  new ArrayList<>();
            while (rs.next()){
                products.add(Product.builder()
                        .name(rs.getString("name"))
                        .price(rs.getInt("price"))
                        .description(rs.getString("description"))
                        .picUrl(rs.getString("pic_url")).build());
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

