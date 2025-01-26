package ru.gb.crud_spring_web.controllers;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ru.gb.crud_spring_web.model.User;
import ru.gb.crud_spring_web.service.UserService;

import java.util.List;

@Controller
@Log
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "forward:/home.html";
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        log.info("Показать всех пользователей");
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        log.info("Открыта страница создания пользователя");
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        log.info(String.format("Пользователь %s %s создан", user.getFirstName(), user.getLastName()));
        return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteById(@PathVariable int id) {
        userService.deleteById(id);
        log.info(String.format("Пользователь с id %d удалён", id));
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        log.info(String.format("Найден пользователь с id %d", id));
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.updateUser(user);
        log.info(String.format("Пользователь с id %d обновлён", user.getId()));
        return "redirect:/users";
    }
}
