package com.duongthuy.project.repository;

import com.duongthuy.project.entity.VoucherInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherInstanceRepository extends JpaRepository<VoucherInstance, Integer> {
}
