package com.duongthuy.project.repository;

import com.duongthuy.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select u.* from users u left join roles r on u.role_id = r.id where r.role_code = :roleCode", nativeQuery = true)
    List<User> findUserByRoleCode(String roleCode);

    @Query(value = "select * from users where username = :username", nativeQuery = true)
    Optional<User> findByUsername(@Param("username") String username);
}
