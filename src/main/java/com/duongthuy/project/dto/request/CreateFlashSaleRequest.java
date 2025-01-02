package com.duongthuy.project.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateFlashSaleRequest {
    private Integer voucherId;
    private Integer discount;
    private Integer availableVouchers;
    private Integer maxParticipants;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}