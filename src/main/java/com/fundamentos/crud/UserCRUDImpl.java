package com.fundamentos.crud;

import com.fundamentos.entity.User;
import com.fundamentos.service.UserService;

import java.util.List;

public class UserCRUDImpl implements UserCRUD{

    private UserService userService;

    public UserCRUDImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @Override
    public User save(User newUser) {
        return userService.save(newUser);
    }
}
