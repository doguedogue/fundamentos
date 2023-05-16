package com.fundamentos.service;

import com.fundamentos.entity.User;
import com.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private final Log LOGGER  = LogFactory.getLog(UserService.class);

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransactional(List<User> users){
        users.stream()
                .peek(user -> LOGGER.info("Usuario insertado en servicio: "+user))
                .forEach(userRepository::save);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow();
        userRepository.delete(new User(id));
    }

    public User updateUser(User updUser, Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(updUser.getName());
                    user.setEmail(updUser.getEmail());
                    user.setBirthDate(updUser.getBirthDate());
                    return userRepository.save(user);
                }).get();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
