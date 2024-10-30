package com.duongthuy.project.repository;

import com.duongthuy.project.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Integer> {

    @Query(value = "select * from vouchers where code = :code", nativeQuery = true)
    Optional<Voucher> findByCode(@Param("code") String code);

    @Query(value = "select * from vouchers where expiration_date > current_date", nativeQuery = true)
    List<Voucher> findAllActiveVouchers();
}
