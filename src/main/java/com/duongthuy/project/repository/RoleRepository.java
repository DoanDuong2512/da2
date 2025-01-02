package com.duongthuy.project.repository;

import com.duongthuy.project.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query(value = "select * from roles where role_code = :roleCode", nativeQuery = true)
    Optional<Role> findByRoleCode(String roleCode);
}
