package com.encanto_boto.saci_flow.row.mapper;

import com.encanto_boto.saci_flow.model.Task;
import com.encanto_boto.saci_flow.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setUsername(rs.getString("username"));
        user.setMail(rs.getString("mail"));
        user.setPassword(rs.getString("password"));

        user.setTasks(new ArrayList<Task>());

        return user;
    }
}
