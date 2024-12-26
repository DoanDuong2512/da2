package com.duongthuy.project.dto.request;

import lombok.Data;

@Data
public class ParticipateFlashSaleRequest {
    private Integer userId;
    private Integer flashSaleId;
}