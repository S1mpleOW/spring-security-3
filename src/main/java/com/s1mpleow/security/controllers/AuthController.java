package com.s1mpleow.security.controllers;

import com.s1mpleow.security.dtos.RegisterDTO;
import com.s1mpleow.security.services.AuthServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServices authServices;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO body) {
        System.out.println(body);
        return ResponseEntity.ok().body(authServices.register(body));
    }
}
