package com.eatup.authserver.repository;

import com.eatup.authserver.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Query(value = "select * from user_role u where u.user_id = ?1", nativeQuery = true)
    List<UserRole> getUserRoleByUserId(Long user_id);
}
