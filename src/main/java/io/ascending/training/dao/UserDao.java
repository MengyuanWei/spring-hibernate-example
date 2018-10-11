package io.ascending.training.dao;

import io.ascending.training.domain.User;

import java.util.List;

public interface UserDao {
    User save(User user);
    List<User> findAll();
}
