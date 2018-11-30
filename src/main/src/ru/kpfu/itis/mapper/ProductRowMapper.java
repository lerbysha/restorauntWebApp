package ru.kpfu.itis.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.kpfu.itis.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        return Product.builder()
                .id(resultSet.getLong("product_id"))
                .name(resultSet.getString("product_name"))
                .build();
    }
}
