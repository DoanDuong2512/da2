package com.duongthuy.project.repository;

import com.duongthuy.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select u.* from users u left join roles r on u.role_id = r.id where u.role_code = :roleCode", nativeQuery = true)
    List<User> findUserByRoleCode(String roleCode);
}
