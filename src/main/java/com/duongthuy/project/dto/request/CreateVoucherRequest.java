package com.duongthuy.project.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CreateVoucherRequest {
    private Integer voucherCategoryId;

    private String usageConditions;

    private BigDecimal minOrderAmount; // Số tiền tối thiểu cho đơn hàng để áp dụng voucher

    private String product; // Sản phẩm áp dụng

    private String productIntro; // Giới thiệu sản phẩm

    private String description; // Mô tả voucher

    private String redemptionLocation; // Địa điểm áp dụng voucher

    private Integer quantityAvailable; // Số lượng sẵn có

    private LocalDate startDate; // Ngày bắt đầu

    private LocalDate endDate; // Ngày kết thúc

    private BigDecimal discountPercent; // Tỷ lệ giảm giá

    private BigDecimal maxDiscountAmount; // Số tiền giảm giá tối đa cho voucher

    private Integer price; // Giá voucher

}
