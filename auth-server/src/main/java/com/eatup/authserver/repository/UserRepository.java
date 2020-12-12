package com.eatup.authserver.repository;

import com.eatup.authserver.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "select u from UserEntity u where u.userName = ?1")
    UserEntity getUserByUsername(String username);

    @Query(value = "select * from users u where u.id = ?1",nativeQuery = true)
    UserEntity getUserByUserId(Long id);

    @Query(value = "select * from users u where u.email = ?1",nativeQuery = true)
    UserEntity getUserByEmail(String email);

}
