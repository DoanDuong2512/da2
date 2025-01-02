package com.duongthuy.project.repository;

import com.duongthuy.project.entity.FlashSale;
import com.duongthuy.project.entity.FlashSaleParticipant;
import com.duongthuy.project.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashSaleParticipantRepository extends JpaRepository<FlashSaleParticipant, Integer> {
    boolean existsByFlashSaleAndUser(FlashSale flashSale, User user);
    List<FlashSaleParticipant> findByFlashSale_IdOrderByTimeJoinedAsc(Integer flashSaleId);
    List<FlashSaleParticipant> findByFlashSale_Id(Integer flashSaleId);
}