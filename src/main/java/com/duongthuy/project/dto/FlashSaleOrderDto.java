package com.duongthuy.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlashSaleVoucherOrderDto {

    private Long orderId;
    private Long voucherId;
    private Long customerId;
    private Integer maxQuantity;
    private String status;
}
