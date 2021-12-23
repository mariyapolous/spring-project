package com.example.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.PermitAll;

/** controller file
 * @author mariyapolous
 *
 */

@Controller
public class FirstController {

    @GetMapping("/main")
    @PermitAll
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "main";
    }

    @GetMapping("/about")
    @PermitAll
    public String about(Model model) {
        model.addAttribute("title", "Про сервис");
        return "about";
    }

    @GetMapping("/login")
    @PermitAll
    public String LoginPage(Model model) {
        model.addAttribute("title", "Вход в аккаунт");
        return "login";
    }

    @GetMapping("/registration")
    @PermitAll
    public String registration(Model model) {
        model.addAttribute("title", "Регистрация пользователя");
        return "registration";
    }


    @GetMapping("/myblog")
    public String myblog(Model model) {
        model.addAttribute("title", "Добро пожаловать!");
        return "myblog";
    }

}
