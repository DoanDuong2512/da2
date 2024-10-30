package com.duongthuy.project.controller;

import com.duongthuy.project.dto.VoucherDto;
import com.duongthuy.project.dto.request.CreateVoucherRequest;
import com.duongthuy.project.dto.request.UpdateVoucherRequest;
import com.duongthuy.project.dto.response.ErrorResponseDto;
import com.duongthuy.project.entity.User;
import com.duongthuy.project.service.VoucherService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/vouchers")
@RequiredArgsConstructor
public class VoucherController {
    private final VoucherService voucherService;

    @GetMapping
    public ResponseEntity<?> findAllVouchers(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size
    ) {
        Page<VoucherDto> vouchers = voucherService.findAllVouchers(page, size);
        return ResponseEntity.ok(vouchers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoucherDto> findVoucherById(@PathVariable Integer id) {
        return ResponseEntity.ok(voucherService.findVoucherById(id));
    }

    @PostMapping
    public ResponseEntity<ErrorResponseDto> createVoucher(@RequestBody CreateVoucherRequest request){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.ok(voucherService.createVoucher(request, currentUser.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ErrorResponseDto> updateVoucher(
            @PathVariable Integer id,
            @RequestBody UpdateVoucherRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return ResponseEntity.ok(voucherService.updateVoucher(request, id, currentUser.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ErrorResponseDto> deleteVoucher(@PathVariable Integer id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return ResponseEntity.ok(voucherService.deleteVoucher(id, currentUser.getId()));
    }

}
