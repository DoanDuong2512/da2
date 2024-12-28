package com.duongthuy.project.service;

import com.duongthuy.project.dto.request.RedeemVoucherRequest;
import com.duongthuy.project.dto.response.VoucherRedemptionResponse;
import com.duongthuy.project.entity.VoucherInstance;
import com.duongthuy.project.entity.VoucherRedemption;
import com.duongthuy.project.repository.VoucherInstanceRepository;
import com.duongthuy.project.repository.VoucherRedemptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class VoucherRedemptionService {
    private final VoucherInstanceRepository voucherInstanceRepository;
    private final VoucherRedemptionRepository voucherRedemptionRepository;

    @Transactional
    public VoucherRedemptionResponse redeemVoucher(RedeemVoucherRequest request) {
        VoucherInstance voucherInstance = voucherInstanceRepository.findByVoucherCode(request.getVoucherCode())
                .orElseThrow(() -> new RuntimeException("Voucher not found"));

        if (!"ACTIVE".equals(voucherInstance.getStatus())) {
            return new VoucherRedemptionResponse("This voucher has been used", null);
        }

        BigDecimal initialAmount = new BigDecimal(request.getInitialAmount());
        BigDecimal discount = new BigDecimal(String.valueOf(voucherInstance.getVoucher().getDiscount())).divide(BigDecimal.valueOf(100));
        BigDecimal discountAmount = initialAmount.multiply(discount);
        BigDecimal finalAmount = initialAmount.subtract(discountAmount);

        VoucherRedemption voucherRedemption = new VoucherRedemption();
        voucherRedemption.setVoucherInstance(voucherInstance);
        voucherRedemption.setRedemptionDate(LocalDateTime.now());
        voucherRedemption.setInitialAmount(request.getInitialAmount());
        voucherRedemption.setDiscountAmount(discountAmount.toString());
        voucherRedemption.setFinalAmount(finalAmount.toString());
        voucherRedemptionRepository.save(voucherRedemption);

        voucherInstance.setStatus("Used");
        voucherInstanceRepository.save(voucherInstance);

        return new VoucherRedemptionResponse("Voucher redeemed successfully", voucherRedemption);
    }
}