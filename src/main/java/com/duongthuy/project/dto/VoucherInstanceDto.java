package com.duongthuy.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoucherInstanceDTO {
    private Long voucherInstanceId;
    private Long voucherId;
    private Long userId;
    private String voucherCode;
    private LocalDateTime createdAt;
    private LocalDateTime purchaseAt;
    private LocalDateTime usedAt;
    private String status;
}
