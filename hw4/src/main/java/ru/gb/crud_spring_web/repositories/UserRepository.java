package ru.gb.crud_spring_web.repositories;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ru.gb.crud_spring_web.model.User;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {
    private final JdbcTemplate jdbc;
    private final SQLConfig sqlConfig;

    public List<User> findAll() {
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sqlConfig.getFindAll(), userRowMapper);
    }

    public User save(User user) {
        jdbc.update(sqlConfig.getSave(), user.getFirstName(), user.getLastName());
        return user;
    }

    public void deleteById(int id) {
        jdbc.update(sqlConfig.getDeleteById(), id);
    }

    public User update(User user) {
        jdbc.update(sqlConfig.getUpdate(), user.getFirstName(), user.getLastName(), user.getId());
        return user;
    }

    public User findById(int id) {
        RowMapper<User> userRowMapper = (r,i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.queryForObject(sqlConfig.getFindById(), userRowMapper, id);
    }
}
