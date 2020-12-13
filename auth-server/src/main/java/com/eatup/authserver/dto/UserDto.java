package com.eatup.authserver.dto;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
}
