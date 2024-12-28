package com.duongthuy.project.controller;

import com.duongthuy.project.dto.request.CreateFlashSaleRequest;
import com.duongthuy.project.dto.request.ParticipateFlashSaleRequest;
import com.duongthuy.project.dto.response.ErrorResponseDto;
import com.duongthuy.project.entity.FlashSale;
import com.duongthuy.project.entity.FlashSaleParticipant;
import com.duongthuy.project.entity.User;
import com.duongthuy.project.service.FlashSaleService;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/flash-sales")
@RequiredArgsConstructor
public class FlashsaleController {
    private final FlashSaleService flashSaleService;

    @PostMapping
    public ResponseEntity<ErrorResponseDto> createFlashSale(@RequestBody CreateFlashSaleRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return ResponseEntity.ok(flashSaleService.createFlashSale(request, currentUser));
    }

    @PostMapping("/participate")
    public ResponseEntity<ErrorResponseDto> participateInFlashSale(@RequestBody ParticipateFlashSaleRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        System.out.println(currentUser);
        return ResponseEntity.ok(flashSaleService.participateInFlashSale(request, currentUser));
    }

    @GetMapping("/participate/{flashSaleId}")
    public ResponseEntity<List<FlashSaleParticipant>> getAllFlashSaleParticipation(@PathVariable Integer flashSaleId) {
        return ResponseEntity.ok(flashSaleService.viewAllFlashSaleParticipants(flashSaleId));
    }

}