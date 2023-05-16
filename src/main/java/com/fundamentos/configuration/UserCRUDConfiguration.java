package com.fundamentos.configuration;

import com.fundamentos.crud.UserCRUD;
import com.fundamentos.crud.UserCRUDImpl;
import com.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserCRUDConfiguration {

    @Bean
    UserCRUD getUsers(UserService userService){
        return new UserCRUDImpl(userService);
    }

}
