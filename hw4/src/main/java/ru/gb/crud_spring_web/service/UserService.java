package ru.gb.crud_spring_web.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import ru.gb.crud_spring_web.model.User;
import ru.gb.crud_spring_web.repositories.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        return userRepository.update(user);
    }

    public User findById(int id) {
        return userRepository.findById(id);
    }
}
