package com.duongthuy.project.controller;

import com.duongthuy.project.dto.VoucherCategoryDto;
import com.duongthuy.project.dto.request.CreateVoucherCategoryDto;
import com.duongthuy.project.dto.request.UpdateVoucherCategoryDto;
import com.duongthuy.project.dto.response.ErrorResponseDto;
import com.duongthuy.project.service.VoucherCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/voucher-categories")
@RequiredArgsConstructor
public class VoucherCategoryController {
    private final VoucherCategoryService voucherCategoryService;

    @PostMapping
    public ResponseEntity<ErrorResponseDto> createVoucherCategory(@RequestBody CreateVoucherCategoryDto request) {
        return ResponseEntity.ok(voucherCategoryService.createVoucherCategory(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ErrorResponseDto> updateVoucherCategory(
            @PathVariable Integer id,
            @RequestBody UpdateVoucherCategoryDto request) {
        return ResponseEntity.ok(voucherCategoryService.updateVoucherCategory(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ErrorResponseDto> deleteVoucherCategory(@PathVariable Integer id) {
        return ResponseEntity.ok(voucherCategoryService.deleteVoucherCategory(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoucherCategoryDto> findVoucherCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(voucherCategoryService.findVoucherCategoryById(id));
    }

    @GetMapping
    public ResponseEntity<?> findAllVoucherCategories() {
        List<VoucherCategoryDto> categories = voucherCategoryService.findAllVoucherCategories();
        return ResponseEntity.ok(categories);
    }
}
