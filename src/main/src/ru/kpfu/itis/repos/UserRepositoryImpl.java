package ru.kpfu.itis.repos;

import ru.kpfu.itis.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private Connection connection;

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean existsByEmail(String email) {
        String sql = "";
        return false;
    }

    @Override
    public Optional<User> findByEmail(String username) {
        String query = "SELECT * FROM restoraunt_user WHERE username = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return Optional.of(User.builder()
                    .id(resultSet.getLong("id"))
                    .username(resultSet.getString("username"))
                    .email(resultSet.getString("email"))
                    .hashPassword(resultSet.getString("hash_password")).build());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByToken(String token) {
        String query = "SELECT * FROM restoraunt_user WHERE token = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, token);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return Optional.of(User.builder()
                    .id(rs.getLong("id"))
                    .username(rs.getString("username"))
                    .email(rs.getString("email"))
                    .hashPassword(rs.getString("hash_password")).build());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO restoraunt_user (username, email, hash_password, token) VALUES (?, ?,?, ?)";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getEmail());
            pstm.setString(3, user.getHashPassword());
            pstm.setString(4, user.getToken());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(User bean) {
        String query = "UPDATE restoraunt_user SET token = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, bean.getToken());
            statement.setLong(2, bean.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }
}
