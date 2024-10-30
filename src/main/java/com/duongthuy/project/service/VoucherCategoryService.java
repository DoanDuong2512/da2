package com.duongthuy.project.service;

import com.duongthuy.project.dto.VoucherCategoryDto;
import com.duongthuy.project.dto.request.CreateVoucherCategoryDto;
import com.duongthuy.project.dto.request.UpdateVoucherCategoryDto;
import com.duongthuy.project.dto.response.ErrorResponseDto;
import com.duongthuy.project.entity.VoucherCategory;
import com.duongthuy.project.repository.VoucherCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class VoucherCategoryService {
    private final VoucherCategoryRepository voucherCategoryRepository;

    private final ModelMapper modelMapper;

    public ErrorResponseDto createVoucherCategory(CreateVoucherCategoryDto request) {
        VoucherCategory voucherCategory = modelMapper.map(request, VoucherCategory.class);
        voucherCategory = voucherCategoryRepository.save(voucherCategory);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage("Create voucher category successfully");
        errorResponseDto.setErrorCode("00");
        errorResponseDto.setSuccess(true);
        errorResponseDto.setData(modelMapper.map(voucherCategory, VoucherCategoryDto.class));
        return errorResponseDto;
    }

    public ErrorResponseDto updateVoucherCategory(UpdateVoucherCategoryDto request, Integer id) {
        Optional<VoucherCategory> optionalCategory = voucherCategoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            return null; // Handle not found case
        }

        VoucherCategory voucherCategory = optionalCategory.get();
        modelMapper.map(request, voucherCategory);
        voucherCategory = voucherCategoryRepository.save(voucherCategory);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage("Update voucher category successfully");
        errorResponseDto.setErrorCode("00");
        errorResponseDto.setSuccess(true);
        errorResponseDto.setData(modelMapper.map(voucherCategory, VoucherCategoryDto.class));
        return errorResponseDto;
    }

    public ErrorResponseDto deleteVoucherCategory(Integer id) {
        voucherCategoryRepository.deleteById(id);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage("Delete voucher category successfully");
        errorResponseDto.setErrorCode("00");
        errorResponseDto.setSuccess(true);
        return errorResponseDto;
    }

    public VoucherCategoryDto findVoucherCategoryById(Integer id) {
        Optional<VoucherCategory> optionalCategory = voucherCategoryRepository.findById(id);
        return optionalCategory.map(voucherCategory -> modelMapper.map(voucherCategory, VoucherCategoryDto.class)).orElse(null);
    }

    public List<VoucherCategoryDto> findAllVoucherCategories(
    ) {
        List<VoucherCategory> voucherCategories = voucherCategoryRepository.findAll();
        return voucherCategories.stream().map(voucherCategory -> modelMapper.map(voucherCategory, VoucherCategoryDto.class))
                .collect(Collectors.toList());
    }
}
