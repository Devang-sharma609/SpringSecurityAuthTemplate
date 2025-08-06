package com.devang.iam.controllers;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class RootController {
    @GetMapping("/")
    public String home(Authentication authentication, CsrfToken token) {
        return authentication.getName() + " is logged in\n" +
               "CSRF Token Header Name: " + token.getHeaderName() + "\n" +
               "CSRF Token Value: " + token.getToken() + "\n";
    }
}