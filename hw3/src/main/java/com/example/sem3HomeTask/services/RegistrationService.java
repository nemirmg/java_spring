package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private UserService userService;
    private DataProcessingService dataProcessingService;
    private NotificationService notificationService;

    public RegistrationService(UserService userService,
                               DataProcessingService dataProcessingService,
                               NotificationService notificationService) {
        this.userService = userService;
        this.dataProcessingService = dataProcessingService;
        this.notificationService = notificationService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public void processRegistration(String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUser(user);
    }
}
