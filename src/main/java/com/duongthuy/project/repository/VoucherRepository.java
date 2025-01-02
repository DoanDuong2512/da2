package com.duongthuy.project.repository;

import com.duongthuy.project.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoucherRepository extends JpaRepository<Voucher, Integer> {

    @Query("SELECT v FROM Voucher v WHERE UPPER(v.product) LIKE UPPER(CONCAT('%', :keyword, '%')) OR UPPER(v.productIntro) LIKE UPPER(CONCAT('%', :keyword, '%')) OR UPPER(v.description) LIKE UPPER(CONCAT('%', :keyword, '%'))")
    List<Voucher> findByKeyword(@Param(value = "keyword") String keyword);
}