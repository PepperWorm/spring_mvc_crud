package com.my_webapp.service;

import com.my_webapp.models.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUser(int id);

    public void saveUser(User user);

    public void updateUser(int id, User user);

    public void deleteUser(int id);
}
