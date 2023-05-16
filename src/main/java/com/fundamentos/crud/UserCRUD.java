package com.fundamentos.crud;

import com.fundamentos.entity.User;

import java.util.List;

public interface UserCRUD {
    public List<User> getAll();

    User save(User newUser);

    void deleteUser(Long id);

    User updateUser(User updUser, Long id);

    User getUser(Long id);

    List<User> getUserPageable(int page, int size);
}
