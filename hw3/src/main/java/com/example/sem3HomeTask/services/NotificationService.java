package com.example.sem3HomeTask.services;

import org.springframework.stereotype.Service;

import com.example.sem3HomeTask.domain.User;

@Service
public class NotificationService {
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }
}
