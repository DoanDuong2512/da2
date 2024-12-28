package com.duongthuy.project.controller;

import com.duongthuy.project.dto.request.CreateFlashSaleRequest;
import com.duongthuy.project.dto.request.ParticipateFlashSaleRequest;
import com.duongthuy.project.dto.response.ErrorResponseDto;
import com.duongthuy.project.service.FlashSaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/flash-sales")
@RequiredArgsConstructor
public class FlashsaleController {
    private final FlashSaleService flashSaleService;

    @PostMapping
    public ResponseEntity<ErrorResponseDto> createFlashSale(@RequestBody CreateFlashSaleRequest request) {
        return ResponseEntity.ok(flashSaleService.createFlashSale(request));
    }

    @PostMapping("/participate")
    public ResponseEntity<ErrorResponseDto> participateInFlashSale(@RequestBody ParticipateFlashSaleRequest request) {

        return ResponseEntity.ok(flashSaleService.participateInFlashSale(request));
    }
}