package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RegistrationService service;

    /*
     Пример запроса для просмотра списка пользователей:

     $ curl -X GET "http://localhost:8080/user" -H "accept: application/json" \
       -D result.headers -o result.json
     */
    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }

    /*
     Пример запроса для регистрации пользователя:

     $ curl -X POST -F "name=Василий" -F "age=27" -F "email=vasya@mail.box" \
       "http://localhost:8080/user/reg" -H "accept: application/json" \
       -D result.headers -o result.json
     */
    @PostMapping("/reg")
    public String userAddFromReg(@RequestParam String name,
                                 @RequestParam int age,
                                 @RequestParam String email) {
        service.processRegistration(name, age, email);
        return "User added after registration!";
    }
}
