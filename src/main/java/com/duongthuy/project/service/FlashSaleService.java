package com.duongthuy.project.service;

import com.duongthuy.project.dto.request.CreateFlashSaleRequest;
import com.duongthuy.project.dto.request.ParticipateFlashSaleRequest;
import com.duongthuy.project.dto.response.ErrorResponseDto;
import com.duongthuy.project.entity.FlashSale;
import com.duongthuy.project.entity.FlashSaleParticipant;
import com.duongthuy.project.entity.User;
import com.duongthuy.project.entity.Voucher;
import com.duongthuy.project.exception.BusinessException;
import com.duongthuy.project.repository.FlashSaleParticipantRepository;
import com.duongthuy.project.repository.FlashSaleRepository;
import com.duongthuy.project.repository.UserRepository;
import com.duongthuy.project.repository.VoucherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FlashSaleService {
    private final FlashSaleRepository flashSaleRepository;
    private final FlashSaleParticipantRepository flashSaleParticipantRepository;
    private final VoucherRepository voucherRepository;
    private final UserRepository userRepository;

    @Transactional
    public ErrorResponseDto createFlashSale(CreateFlashSaleRequest request) {
        Voucher voucher = voucherRepository.findById(request.getVoucherId())
                .orElseThrow(() -> new BusinessException("Voucher not found"));

        FlashSale flashSale = new FlashSale();
        flashSale.setVoucher(voucher);
        flashSale.setDiscount(request.getDiscount());
        flashSale.setAvailableVouchers(request.getAvailableVouchers());
        flashSale.setMaxParticipants(request.getMaxParticipants());
        flashSale.setStartTime(request.getStartTime());
        flashSale.setEndTime(request.getEndTime());
        flashSaleRepository.save(flashSale);

        return new ErrorResponseDto(true, "Flash sale created successfully", null);
    }

    @Transactional
    public ErrorResponseDto participateInFlashSale(ParticipateFlashSaleRequest request) {
        FlashSale flashSale = flashSaleRepository.findById(request.getFlashSaleId())
                .orElseThrow(() -> new BusinessException("Flash sale not found"));

        if (LocalDateTime.now().isBefore(flashSale.getStartTime()) || LocalDateTime.now().isAfter(flashSale.getEndTime())) {
            throw new BusinessException("Flash sale is not active");
        }

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new BusinessException("User not found"));

        if (flashSaleParticipantRepository.existsByFlashSaleAndUser(flashSale, user)) {
            throw new BusinessException("User has already participated in this flash sale");
        }

        FlashSaleParticipant participant = new FlashSaleParticipant();
        participant.setFlashSale(flashSale);
        participant.setUser(user);
        participant.setStatus("Joined");
        flashSaleParticipantRepository.save(participant);

        return new ErrorResponseDto(true, "Joined successfully", "Joined");
    }
}