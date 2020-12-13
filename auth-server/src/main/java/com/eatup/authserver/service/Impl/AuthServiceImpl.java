package com.eatup.authserver.service.Impl;

import com.eatup.authserver.dto.UserDto;
import com.eatup.authserver.entity.UserEntity;
import com.eatup.authserver.repository.UserRepository;
import com.eatup.authserver.service.AuthService;
import liquibase.pro.packaged.D;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserDto signup(UserDto userDto) {
        try {
            UserEntity user = modelMapper.map(userDto, UserEntity.class);
            user.setIsActive(true);
            user.setCreatedDate(new Date());
            user.setUpdatedDate(new Date());
            userRepository.save(user);
            return userDto;
        }catch (Exception e) {
            throw e;
        }
    }

}
