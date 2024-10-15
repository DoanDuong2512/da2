package com.duongthuy.project.repository;

import com.duong.restful_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE UPPER(u.fullName) LIKE UPPER(CONCAT('%', :keyword, '%'))")
    List<User> findByNameContaining(@Param(value = "keyword") String keyword);
}
