package com.duongthuy.project.repository;

import com.duongthuy.project.entity.VoucherInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoucherInstanceRepository extends JpaRepository<VoucherInstance, Integer> {
    Optional<VoucherInstance> findByVoucherCode(String voucherCode);
}