package com.eatup.authserver.service;

import com.eatup.authserver.model.LoginUserModel;

import java.util.List;

public interface EatupCustomQueryService {
    List<LoginUserModel> getUserAndRolesByUsername(String username);
}
