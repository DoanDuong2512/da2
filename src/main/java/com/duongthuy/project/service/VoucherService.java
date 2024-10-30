package com.duongthuy.project.service;

import com.duongthuy.project.dto.VoucherDto;
import com.duongthuy.project.dto.request.CreateVoucherRequest;
import com.duongthuy.project.dto.request.UpdateVoucherRequest;
import com.duongthuy.project.dto.response.ErrorResponseDto;
import com.duongthuy.project.entity.User;
import com.duongthuy.project.entity.Voucher;
import com.duongthuy.project.entity.VoucherCategory;
import com.duongthuy.project.repository.UserRepository;
import com.duongthuy.project.repository.VoucherCategoryRepository;
import com.duongthuy.project.repository.VoucherInstanceRepository;
import com.duongthuy.project.repository.VoucherRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class VoucherService {
    private final VoucherRepository voucherRepository;

    private final VoucherInstanceRepository voucherInstanceRepository;

    private final VoucherCategoryRepository voucherCategoryRepository;

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public ErrorResponseDto createVoucher(CreateVoucherRequest request, Integer supplierId) {
        Voucher voucher = modelMapper.map(request, Voucher.class);

        VoucherCategory voucherCategory = voucherCategoryRepository.findById(request.getVoucherCategoryId()).orElse(null);
        if (voucherCategory == null) {
            return new ErrorResponseDto(false, "Voucher category not found", "01");
        }

        User supplier = userRepository.findById(supplierId).orElse(null);
        if (supplier == null) {
            return new ErrorResponseDto(false, "Supplier not found", "01");
        }

        // Set default values or initialize fields
        voucher.setRatingsCount(0); // Default ratings count
        voucher.setAverageRating(BigDecimal.ZERO); // Default average rating
        voucher.setQuantityAvailable(request.getQuantityAvailable()); // Set available quantity
        voucher.setQuantitySold(0); // Initially sold quantity is 0
        voucher.setIsActive(true); // Set active status by default
        voucher.setStartDate(request.getStartDate()); // Set current date as start date if not provided
        voucher.setEndDate(request.getEndDate()); // Use provided end date
        voucher.setSupplier(supplier); // Set supplier
        voucher.setCategory(voucherCategory); // Set category

        voucherRepository.save(voucher);

        ErrorResponseDto response = new ErrorResponseDto();
        response.setMessage("Create voucher successfully");
        response.setErrorCode("00");
        response.setSuccess(true);
        return response;
    }

    public ErrorResponseDto updateVoucher(UpdateVoucherRequest request, Integer id, Integer supplierId) {
        if (!voucherRepository.existsById(id)) {
            return new ErrorResponseDto(false, "Voucher not found", "01");
        }

        Voucher voucher = modelMapper.map(request, Voucher.class);
        voucher.setId(id);

        VoucherCategory voucherCategory = voucherCategoryRepository.findById(request.getVoucherCategoryId()).orElse(null);
        if (voucherCategory == null) {
            return new ErrorResponseDto(false, "Voucher category not found", "01");
        }

        if(!Objects.equals(voucher.getSupplier().getId(), supplierId)){
            return new ErrorResponseDto(false, "You are not the owner of this voucher", "01");
        }

        voucher.setCategory(voucherCategory);

        voucherRepository.save(voucher);

        ErrorResponseDto response = new ErrorResponseDto();
        response.setMessage("Update voucher successfully");
        response.setErrorCode("00");
        response.setSuccess(true);
        return response;
    }


    public ErrorResponseDto deleteVoucher(Integer id, Integer userId) {
        Voucher voucher = voucherRepository.findById(id).orElse(null);
        if (voucher == null) {
            return new ErrorResponseDto(false, "Voucher not found", "01");
        }

        if(!Objects.equals(voucher.getSupplier().getId(), userId)){
            return new ErrorResponseDto(false, "You are not the owner of this voucher", "01");
        }

        voucherRepository.deleteById(id);

        ErrorResponseDto response = new ErrorResponseDto();
        response.setMessage("Delete voucher successfully");
        response.setErrorCode("00");
        response.setSuccess(true);
        return response;
    }

    public VoucherDto findVoucherById(Integer id) {
        Optional<Voucher> optionalVoucher = voucherRepository.findById(id);
        return optionalVoucher.map(voucher -> modelMapper.map(voucher, VoucherDto.class)).orElse(null);
    }

    public Page<VoucherDto> findAllVouchers(
            int page,
            int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return voucherRepository.findAll(pageable).map(voucher -> modelMapper.map(voucher, VoucherDto.class));
    }


}
