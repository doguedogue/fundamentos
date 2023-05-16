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

    @Override
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    @Override
    public User updateUser(User updUser, Long id) {
        return userService.updateUser(updUser, id);
    }

    @Override
    public User getUser(Long id) {
        return userService.getUser(id);
    }

    @Override
    public List<User> getUserPageable(int page, int size) {
        return userService.getUserPageable(page,size);
    }
}
