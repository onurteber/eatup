package com.eatup.authserver.repository;

import com.eatup.authserver.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository  extends JpaRepository<Role, Long> {

    @Query(value = "select * from roles u where u.id = ?1",nativeQuery = true)
    Role getRoleByRoleId(Long role_id);
}
