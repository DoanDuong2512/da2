package com.duongthuy.project.repository;

import com.duongthuy.project.entity.VoucherCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherCategoryRepository extends JpaRepository<VoucherCategory, Integer> {
}
