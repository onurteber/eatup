package com.eatup.authserver.service;

import com.eatup.authserver.dto.UserDto;
import org.springframework.http.RequestEntity;

public interface AuthService {

    UserDto signup(UserDto userDto);

}
