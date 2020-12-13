package com.eatup.authserver.controller;

import com.eatup.authserver.dto.UserDto;
import com.eatup.authserver.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody UserDto userDto) {

        try {
            UserDto signup = authService.signup(userDto);
            return ResponseEntity.ok(signup);
        } catch (Exception e) { // TODO Exception must be handled
            throw e;
        }
    }

}