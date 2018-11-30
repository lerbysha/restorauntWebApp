/*
package ru.kpfu.itis.repos;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.phoenigm.recipe_master.mapper.RecipeRowMapper;
import ru.phoenigm.recipe_master.mapper.UserRowMapper;
import ru.phoenigm.recipe_master.model.Recipe;
import ru.phoenigm.recipe_master.model.User;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class RecipeRepositoryImpl implements RecipeRepository {
    private JdbcTemplate jdbc;
    private DataSource dataSource;

    public RecipeRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Recipe> findById(Long id) {
        String query = "SELECT first_name,\n" +
                "       second_name,\n" +
                "       email,\n" +
                "       hash_password,\n" +
                "       service_user.id AS user_id,\n" +
                "       avatar_url,\n" +
                "       last_seen,\n" +
                "       username,\n" +
                "       token,\n" +
                "       r.title         AS rank,\n" +
                "       recipee.id      AS recipe_id,\n" +
                "       recipee.title   AS title,\n" +
                "       recipee.picture_url,\n" +
                "       recipee.cooking_time,\n" +
                "       recipee.cooking_difficulty,\n" +
                "       (SELECT avg(rating)\n" +
                "FROM user_recipe_rating urr\n" +
                "WHERE recipee.id = ?) AS rating,\n" +
                "       recipee.description,\n" +
                "       recipee.publication_date,\n" +
                "       ingred.id       AS ingredient_id,\n" +
                "       ingred.info,\n" +
                "       prod.name       AS product_name,\n" +
                "       prod.id         AS product_id,\n" +
                "       prod.calorific_value\n" +
                "\n" +
                "FROM service_user\n" +
                "       LEFT JOIN rank r ON service_user.rank_hierarchy_level = r.hierarchy_level\n" +
                "       LEFT JOIN user_to_recipe utr ON service_user.id = utr.user_id\n" +
                "       LEFT JOIN recipe recipee ON utr.recipe_id = recipee.id\n" +
                "       LEFT JOIN recipe_to_ingredient ingredient ON recipee.id = ingredient.recipe_id\n" +
                "       LEFT JOIN ingredient ingred ON ingredient.ingredient_id = ingred.id\n" +
                "       LEFT JOIN product prod ON ingred.product_id = prod.id\n" +
                "WHERE recipee.id = ?;";
        try {
            PreparedStatement statement = dataSource.getConnection().prepareStatement(
                    query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setLong(1, id);
            statement.setLong(2, id);
            ResultSet resultSet = statement.executeQuery();
            Recipe recipe = new RecipeRowMapper().getRecipe(resultSet);
            if (recipe != null) {
                recipe.setStarredUsers(this.getUsersStarredRecipe(recipe));
            }
            return recipe != null ? Optional.of(recipe) : Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void save(Recipe bean) {
        String query = "INSERT INTO recipe\n" +
                "VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, DEFAULT);";
        String queryForLinkingUserAndRecipe = "INSERT INTO user_to_recipe\n" +
                "VALUES (?, ?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(query, new String[]{"id"});
            statement.setTimestamp(1, new Timestamp(bean.getPublicationDate().getTime()));
            statement.setString(2, bean.getTitle());
            statement.setString(3, bean.getDescription());
            statement.setFloat(4, bean.getRating() == null ? 0 : bean.getRating());
            statement.setInt(5, bean.getCookingDifficulty());
            statement.setInt(6, bean.getCookingTime());
            return statement;
        }, keyHolder);
        bean.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        jdbc.update(queryForLinkingUserAndRecipe, bean.getUser().getId(), bean.getId());
    }

    @Override
    public void update(Recipe bean) {
        String query = "UPDATE recipe SET (rating) = (SELECT avg(urr.rating) FROM user_recipe_rating urr JOIN recipe  ON urr.recipe_id == recipe.id)";
        try {
            PreparedStatement statement = dataSource.getConnection().prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        String query = "DELETE FROM recipe WHERE id = ?";
        try {
            PreparedStatement statement = dataSource.getConnection().prepareStatement(query);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Recipe> findAll() {
        String query = "SELECT first_name,\n" +
                "       second_name,\n" +
                "       email,\n" +
                "       hash_password,\n" +
                "       service_user.id AS user_id,\n" +
                "       avatar_url,\n" +
                "       last_seen,\n" +
                "       username,\n" +
                "       token,\n" +
                "       r.title         AS rank,\n" +
                "       recipee.id      AS recipe_id,\n" +
                "       recipee.title   AS title,\n" +
                "       recipee.picture_url,\n" +
                "       recipee.cooking_time,\n" +
                "       recipee.cooking_difficulty,\n" +
                "       recipee.rating,\n" +
                "       recipee.description,\n" +
                "       recipee.publication_date,\n" +
                "       ingred.id       AS ingredient_id,\n" +
                "       ingred.info,\n" +
                "       prod.name       AS product_name,\n" +
                "       prod.id         AS product_id,\n" +
                "       prod.calorific_value\n" +
                "\n" +
                "FROM recipe AS recipee\n" +
                "       LEFT JOIN user_to_recipe utr ON utr.recipe_id = recipee.id\n" +
                "       LEFT JOIN service_user ON service_user.id = utr.user_id\n" +
                "       LEFT JOIN rank r ON service_user.rank_hierarchy_level = r.hierarchy_level\n" +
                "       LEFT JOIN recipe_to_ingredient ingredient ON recipee.id = ingredient.recipe_id\n" +
                "       LEFT JOIN ingredient ingred ON ingredient.ingredient_id = ingred.id\n" +
                "       LEFT JOIN product prod ON ingred.product_id = prod.id";
        try {
            PreparedStatement statement = dataSource.getConnection().prepareStatement(query,
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery();
            return new RecipeRowMapper().mapRow(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Recipe> findTopRecipes(int number) {
        String query = "SELECT first_name,\n" +
                "       second_name,\n" +
                "       email,\n" +
                "       hash_password,\n" +
                "       service_user.id AS user_id,\n" +
                "       avatar_url,\n" +
                "       last_seen,\n" +
                "       username,\n" +
                "       token,\n" +
                "       r.title         AS rank,\n" +
                "       recipee.id      AS recipe_id,\n" +
                "       recipee.title   AS title,\n" +
                "       recipee.picture_url,\n" +
                "       recipee.cooking_time,\n" +
                "       recipee.cooking_difficulty,\n" +
                "       recipee.rating,\n" +
                "       recipee.description,\n" +
                "       recipee.publication_date,\n" +
                "       ingred.id       AS ingredient_id,\n" +
                "       ingred.info,\n" +
                "       prod.name       AS product_name,\n" +
                "       prod.id         AS product_id,\n" +
                "       prod.calorific_value\n" +
                "\n" +
                "FROM recipe AS recipee\n" +
                "       LEFT JOIN user_to_recipe utr ON utr.recipe_id = recipee.id\n" +
                "       LEFT JOIN service_user ON service_user.id = utr.user_id\n" +
                "       LEFT JOIN rank r ON service_user.rank_hierarchy_level = r.hierarchy_level\n" +
                "       LEFT JOIN recipe_to_ingredient ingredient ON recipee.id = ingredient.recipe_id\n" +
                "       LEFT JOIN ingredient ingred ON ingredient.ingredient_id = ingred.id\n" +
                "       LEFT JOIN product prod ON ingred.product_id = prod.id ORDER BY rating DESC, publication_date LIMIT ?";
        try {
            PreparedStatement statement = dataSource.getConnection().prepareStatement(query,
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setInt(1, number);
            ResultSet resultSet = statement.executeQuery();
            return new RecipeRowMapper().mapRow(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    private List<User> getUsersStarredRecipe(Recipe recipe) {
        List<User> users = new ArrayList<>();

        String query = "SELECT service_user.id AS user_id, first_name, second_name, email, hash_password, avatar_url, ran.title, username, token, last_seen, r.title AS rank\n" +
                "FROM service_user\n" +
                "       JOIN user_recipe_rating rating ON service_user.id = rating.user_id\n" +
                "       JOIN recipe r ON rating.recipe_id = r.id\n" +
                "       JOIN rank ran ON service_user.rank_hierarchy_level = ran.hierarchy_level\n" +
                "WHERE r.id = ?;";
        try {
            PreparedStatement statement = dataSource.getConnection().prepareStatement(query);
            statement.setLong(1, recipe.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(new UserRowMapper().mapRow(resultSet, 1));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
*/
