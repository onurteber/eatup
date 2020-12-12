package com.eatup.authserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto implements Serializable {

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String description;
    private String location;
    private Boolean isVerified;
    private Boolean isActive;
    private Date birthDate;
    private Date createdDate;
    private Date updatedDate;
    private Long addressId;
}
