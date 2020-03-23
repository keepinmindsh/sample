package lines.reactive.sample.sample08.mapper;


import lines.reactive.sample.sample08.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUSER_ID(resultSet.getString("USER_ID"));
        return user;
    }
}
