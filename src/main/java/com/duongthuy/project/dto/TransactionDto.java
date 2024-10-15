package com.duongthuy.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDTO {
    private Long transactionId;
    private LocalDateTime transactionDate;
    private BigDecimal amountPaid;
    private Long supplierId;
    private Long customerId;
    private String paymentMethod;
}
