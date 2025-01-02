// TransactionService.java
package com.duongthuy.project.service;

import com.duongthuy.project.dto.request.VoucherTransactionRequest;
import com.duongthuy.project.entity.Transaction;
import com.duongthuy.project.entity.TransactionDetail;
import com.duongthuy.project.entity.User;
import com.duongthuy.project.entity.Voucher;
import com.duongthuy.project.entity.VoucherInstance;
import com.duongthuy.project.exception.BusinessException;
import com.duongthuy.project.repository.TransactionDetailRepository;
import com.duongthuy.project.repository.TransactionRepository;
import com.duongthuy.project.repository.UserRepository;
import com.duongthuy.project.repository.VoucherInstanceRepository;
import com.duongthuy.project.repository.VoucherRepository;
import com.duongthuy.project.util.VoucherCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final VoucherRepository voucherRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionDetailRepository transactionDetailRepository;
    private final VoucherInstanceRepository voucherInstanceRepository;
    private final UserRepository userRepository;

    @Transactional
    public void processVoucherTransaction(Integer voucherId, Integer customerId, Integer quantity, String paymentMethod, Integer discount) {
        System.out.println("something" +voucherId);
        Voucher voucher = voucherRepository.findById(voucherId)
                .orElseThrow(() -> new BusinessException("Voucher not found"));
        if (!voucher.getIsActive() || voucher.getQuantityAvailable() < quantity) {
            throw new BusinessException("Voucher is not available or quantity is insufficient");
        }

        User customer = userRepository.findById(customerId)
                .orElseThrow(() -> new BusinessException("Customer not found"));
        User supplier = userRepository.findById(voucher.getSupplierId())
                .orElseThrow(() -> new BusinessException("Supplier not found"));

        Transaction transaction = new Transaction();
        transaction.setTransactionDate(LocalDateTime.now().toLocalDate());
        transaction.setAmountPaid(voucher.getPrice()
            .multiply(BigDecimal.valueOf(quantity))
            .multiply(BigDecimal.valueOf(100 - discount))
            .divide(BigDecimal.valueOf(100))
        );
        transaction.setSupplier(supplier);
        transaction.setCustomer(customer);
        transaction.setPaymentMethod(paymentMethod);
        transactionRepository.save(transaction);

        TransactionDetail transactionDetail = new TransactionDetail();
        transactionDetail.setTransaction(transaction);
        transactionDetail.setQuantity(quantity);
        transactionDetail.setVoucherId(voucher.getId());
        transactionDetailRepository.save(transactionDetail);


        for (int i = 0; i < quantity; i++) {
            VoucherInstance instance = new VoucherInstance();
            instance.setVoucher(voucher);
            instance.setUser(customer);
            String voucherCode = VoucherCodeGenerator.generateVoucherCode(10);
            instance.setVoucherCode(voucherCode);
            instance.setPurchaseAt(Timestamp.valueOf(LocalDateTime.now()));
            instance.setStatus("ACTIVE");
            voucherInstanceRepository.save(instance);
        }

        // Update voucher quantity
        voucher.setQuantityAvailable(voucher.getQuantityAvailable() - quantity);
        voucherRepository.save(voucher);
        System.out.println("nah"+voucher);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }


}
