package com.wq.produce.jdbc;

import java.util.List;

import com.wq.produce.model.User;

public interface UserDataJdbcRepository {
    List<User> getUsers();
}
