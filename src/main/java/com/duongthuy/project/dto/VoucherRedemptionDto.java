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
public class VoucherRedemptionDto {
    private Long redemptionId;
    private Long voucherInstanceId;
    private LocalDateTime redemptionDate;
    private String location;
    private String status;
    private String initialAmount;
    private String discountAmount;
    private String finalAmount;
}
