package com.duongthuy.project.repository;

import com.duongthuy.project.entity.FlashSale;
import com.duongthuy.project.entity.FlashSaleParticipant;
import com.duongthuy.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashSaleParticipantRepository extends JpaRepository<FlashSaleParticipant, Integer> {
    boolean existsByFlashSaleAndUser(FlashSale flashSale, User user);
}