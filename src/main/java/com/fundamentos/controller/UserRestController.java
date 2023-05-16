package com.fundamentos.controller;

import com.fundamentos.crud.UserCRUD;
import com.fundamentos.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/users")
public class UserRestController {

    private UserCRUD userCRUD;

    public UserRestController(UserCRUD userCRUD) {
        this.userCRUD = userCRUD;
    }

    @GetMapping("/")
    List<User> getAll(){
        return userCRUD.getAll();
    }

    @PostMapping("/")
    ResponseEntity<User> saveUser(@RequestBody User newUser){
        User user = null;
        try {
            user = userCRUD.save(newUser);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id){
        try {
            userCRUD.deleteUser(id);
        }catch (Exception e){
            return new ResponseEntity("El usuario con id: "+id+" no existe", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> updateUser(@RequestBody User updUser, @PathVariable Long id){
        User user = null;
        try {
            user = userCRUD.updateUser(updUser, id);
        }catch (Exception e){
            return new ResponseEntity("El usuario con id: "+id+" no existe", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    User getUser(@PathVariable Long id){
        return userCRUD.getUser(id);
    }
}
