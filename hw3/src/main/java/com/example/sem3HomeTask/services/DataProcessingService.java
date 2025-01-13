package com.example.sem3HomeTask.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.sem3HomeTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sem3HomeTask.domain.User;

@Service
public class DataProcessingService {
    @Autowired
    private UserRepository repository;

    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
        .sorted(Comparator.comparing(User::getAge))
        .collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
        .filter(user -> user.getAge() > age)
        .collect(Collectors.toList());
    }

    public double calculateAverageAge(List<User> users) {
        return users.stream()
        .mapToInt(User::getAge)
        .average()
        .orElse(0);
    }

    public void addUser(User user) {
        repository.getUsers().add(user);
    }

    public UserRepository getRepository() {
        return repository;
    }
}
