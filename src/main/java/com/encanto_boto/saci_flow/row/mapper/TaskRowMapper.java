package com.encanto_boto.saci_flow.row.mapper;

import com.encanto_boto.saci_flow.dto.UserDTO;
import com.encanto_boto.saci_flow.model.Task;
import com.encanto_boto.saci_flow.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();
        task.setId(rs.getLong("id"));
        task.setTitle(rs.getString("title"));
        task.setDescription(rs.getString("description"));
        task.setCompleted(rs.getBoolean("completed"));
        task.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        task.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());

        User user = new User();
//        user.setId(rs.getLong("user_id"));
        user.setUsername(rs.getString("username"));
        user.setId(rs.getLong("user_id"));
//        task.setUser(user);
        task.setUserDTO(new UserDTO(user.getId(), user.getUsername()));

        return task;
    }
}
