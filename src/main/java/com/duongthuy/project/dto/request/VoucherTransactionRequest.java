package com.duongthuy.project.dto.request;

import lombok.Data;

@Data
public class VoucherTransactionRequest {
    private Integer customerId;
    private Integer quantity;
    private String paymentMethod;
}
