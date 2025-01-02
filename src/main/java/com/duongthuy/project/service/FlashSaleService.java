package com.duongthuy.project.service;

import com.duongthuy.project.dto.request.CreateFlashSaleRequest;
import com.duongthuy.project.dto.request.FlashSaleQueueRequest;
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
import com.duongthuy.project.worker.FlashSaleQueueService;
import java.util.List;
import java.util.Objects;
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
    private final TransactionService transactionService;
    private final UserRepository userRepository;
    private final FlashSaleQueueService queueService;

    @Transactional
    public ErrorResponseDto createFlashSale(CreateFlashSaleRequest request, User user) {
        Voucher voucher = voucherRepository.findById(request.getVoucherId())
                .orElseThrow(() -> new BusinessException("Voucher not found"));

        if(!Objects.equals(voucher.getSupplier().getId(), user.getId())) {
            throw new BusinessException("Supplier not match");
        }

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
    public ErrorResponseDto participateInFlashSale(ParticipateFlashSaleRequest request, User user) {
        queueService.addRequest(new FlashSaleQueueRequest(request, user));
        return new ErrorResponseDto(true, "Your request has been added to the queue", "PENDING");
    }

    public void processFlashSaleRequest(ParticipateFlashSaleRequest request, User user) {
        FlashSale flashSale = flashSaleRepository.findById(request.getFlashSaleId())
            .orElseThrow(() -> new BusinessException("Flash sale not found"));

        if (LocalDateTime.now().isBefore(flashSale.getStartTime()) || LocalDateTime.now().isAfter(flashSale.getEndTime())) {
            throw new BusinessException("Flash sale is not active");
        }

        if (flashSaleParticipantRepository.existsByFlashSaleAndUser(flashSale, user)) {
            throw new BusinessException("User has already participated in this flash sale");
        }

        FlashSaleParticipant participant = new FlashSaleParticipant();
        participant.setFlashSale(flashSale);
        participant.setTimeJoined(LocalDateTime.now());
        participant.setUser(user);

        if(flashSale.getAvailableVouchers() > 0){
            processJoinedParticipants(participant);
            flashSale.setAvailableVouchers(flashSale.getAvailableVouchers() - 1);
            flashSaleRepository.save(flashSale);
            return;
        }
        participant.setStatus("REJECTED");
        flashSaleParticipantRepository.save(participant);
    }


    public List<FlashSaleParticipant> viewAllFlashSaleParticipants(Integer flashSaleId) {
        return flashSaleParticipantRepository.findByFlashSale_Id(flashSaleId);
    }


    private void processJoinedParticipants(FlashSaleParticipant participant) {
            participant.setStatus("ACCEPTED");
            transactionService.processVoucherTransaction(
                participant.getFlashSale().getVoucher().getId(),
                participant.getUser().getId(),
                1,
                "CREDIT-CARD",
                participant.getFlashSale().getDiscount()
            );
            flashSaleParticipantRepository.save(participant);
    }

}