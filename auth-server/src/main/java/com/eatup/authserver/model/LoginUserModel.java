package com.eatup.authserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class LoginUserModel {

    @Id
    private Long id;
    private String userName;
    private String password;
    private Boolean active;
    private String name;

}