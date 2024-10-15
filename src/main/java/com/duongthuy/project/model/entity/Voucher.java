package com.duongthuy.project.model.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
package com.final_project.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "vouchers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voucherId;

    @ManyToOne
    @JoinColumn(name = "category_category_id", referencedColumnName = "voucher_category_id")
    private VoucherCategory category;

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "userId")
    private User supplier;

    @Column(name = "usage_conditions", columnDefinition = "TEXT")
    private String usageConditions;

    @Column(name = "min_order_amount", precision = 10, scale = 2)
    private BigDecimal minOrderAmount;

    @Column(name = "product", columnDefinition = "TEXT")
    private String product;

    @Column(name = "product_intro", columnDefinition = "TEXT")
    private String productIntro;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "redemption_location", length = 255)
    private String redemptionLocation;

    @Column(name = "ratings_count")
    private Integer ratingsCount;

    @Column(name = "average_rating", precision = 2, scale = 1)
    private BigDecimal averageRating;

    @Column(name = "quantity_available")
    private Integer quantityAvailable;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "discount_percent", precision = 5, scale = 2)
    private BigDecimal discountPercent;

    @Column(name = "max_discount_amount", precision = 10, scale = 2)
    private BigDecimal maxDiscountAmount;

    @Column(name = "price")
    private Integer price;

    @Column(name = "quantity_sold")
    private Integer quantitySold;

    @Column(name = "is_active")
    private Boolean isActive;
}
