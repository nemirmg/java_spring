package ru.gb.hw7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/public")
    public String publicPage() {
        return "public";
    }

    @GetMapping("/private")
    public String privatePage() {
        return "private";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }
}
