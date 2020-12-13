package com.eatup.authserver.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @CreatedDate
    @NotNull
    @Column(name = "created_date")
    private Date createdDate;

    @LastModifiedDate
    @NotNull
    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "address_id")
    private Long addressId;
}
