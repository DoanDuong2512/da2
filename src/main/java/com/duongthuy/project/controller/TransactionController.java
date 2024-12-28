package com.duongthuy.project.controller;

import com.duongthuy.project.dto.request.VoucherTransactionRequest;
import com.duongthuy.project.entity.Transaction;
import com.duongthuy.project.entity.User;
import com.duongthuy.project.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    @PostMapping("/voucher/{voucherId}")
    public ResponseEntity<String> processVoucherTransaction(
            @PathVariable(name = "voucherId") Integer voucherId,
            @RequestBody VoucherTransactionRequest request) {
        System.out.println(request);
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User currentUser = (User) authentication.getPrincipal();

            transactionService.processVoucherTransaction(voucherId, currentUser.getId(),
                request.getQuantity(), request.getPaymentMethod(), 0);
            return ResponseEntity.ok("Purchase voucher successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing voucher transaction");
        }
    }


    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }
}