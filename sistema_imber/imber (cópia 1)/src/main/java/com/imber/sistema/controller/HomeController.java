package com.imber.sistema.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "Bem-vindo! <a href='/oauth2/authorization/google'>Login com Google</a>";
    }

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal OAuth2User user) {
        String nome = user.getAttribute("name");
        String email = user.getAttribute("email");
        return "Olá, " + nome + " (" + email + ")!";
    }
}