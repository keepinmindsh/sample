package com.lines.sql.dao;

import com.lines.sql.model.UserDTO;

import java.util.List;

public interface UserDao {
    List<UserDTO> selectUsers(UserDTO param) throws Exception;
}
