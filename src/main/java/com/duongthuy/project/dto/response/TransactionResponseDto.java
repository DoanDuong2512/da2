// TransactionResponseDto.java
package com.duongthuy.project.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class TransactionResponseDto {
    private Long transactionId;
    private BigDecimal amountPaid;
    private List<String> voucherCodes;
    private String message;
}
