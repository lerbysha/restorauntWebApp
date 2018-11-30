package ru.kpfu.itis.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.kpfu.itis.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return User.builder()
                .email(resultSet.getString("email"))
                .username(resultSet.getString("username"))
                .hashPassword(resultSet.getString("hash_password"))
                .id(resultSet.getLong("user_id"))
                .token(resultSet.getString("token"))
                .build();
    }

    public User mapRow(ResultSet resultSet) throws SQLException {
        User user = null;
        while (resultSet.next()) {
            user = mapRow(resultSet, 1);
        }
        return user;
    }


}
