package com.eatup.gatewayserver.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {

    @Id
    private Long id;

    @NotNull
    @Column(name = "user_name", unique = true)
    private String userName;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "description")
    private  String description;

    @Column(name = "location")
    private String location;

    @Column(name = "verified")
    private Boolean isVerified;

    @NotNull
    @Column(name = "active")
    private Boolean isActive;

    @Column(name = "birth_date")
    private Date birthDate;

    @NotNull
    @Column(name = "created_date")
    private Date createdDate;

    @NotNull
    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "address_id")
    private Long addressId;
}
