package com.devang.iam.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.devang.iam.models.AppUsers;
import com.devang.iam.repositories.MyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class SignupController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MyRepository repo;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody AppUsers user) {
        if (repo.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username taken");
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            repo.save(user);
            System.out.println(user.getUsername() + " added successfully");
            return ResponseEntity.ok("User '" + user.getUsername() + "' registered successfully.");
        }
    }
}