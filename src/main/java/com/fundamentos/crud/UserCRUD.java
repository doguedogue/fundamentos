package com.fundamentos.crud;

import com.fundamentos.entity.User;

import java.util.List;

public interface UserCRUD {
    public List<User> getAll();

    User save(User newUser);
}
