package com.example.springsecurityexamples.controller;

import com.example.springsecurityexamples.domain.UserRequest;
import com.example.springsecurityexamples.service.UserDetailServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(LoginController.path)
public class LoginController {
    static final String path = "login";
    private final UserDetailServiceImpl userDetailService;

    public LoginController(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping
    public ResponseEntity<UserDetails> authenticate(@RequestBody UserRequest userRequest){
        UserDetails userDetails = userDetailService.loadUserByUsername(userRequest.getUsername());
        return ResponseEntity.ok(userDetails);
    }
}
