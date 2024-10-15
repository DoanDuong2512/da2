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
@Table(name = "flash_sale_vouchers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlashSaleVoucher {
    @ManyToOne
    @JoinColumn(name = "vouchers_voucher_id", referencedColumnName = "voucher_id")
    private Voucher voucher;

    @ManyToOne
    @JoinColumn(name = "flash_sale_voucher_flashsale_id", referencedColumnName = "flashsale_id")
    private FlashSale flashSale;

    @Column(name = "final_amount")
    private Integer finalAmount;
}
