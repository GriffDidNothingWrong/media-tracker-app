package com.mediatrack.app.service;

import com.mediatrack.app.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User saveUser(User user);
}
