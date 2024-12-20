package com.duongthuy.project.controller;

import com.duongthuy.project.dto.request.VoucherTransactionRequest;
import com.duongthuy.project.dto.response.ErrorResponseDto;
import com.duongthuy.project.entity.Transaction;
import com.duongthuy.project.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/voucher/{voucherId}")
    public ResponseEntity<ErrorResponseDto> processVoucherTransaction(
            @PathVariable(name = "voucherId") Integer voucherId,
            @RequestBody VoucherTransactionRequest request) {
        return ResponseEntity.ok(transactionService.processVoucherTransaction(voucherId, request));
    }
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

}