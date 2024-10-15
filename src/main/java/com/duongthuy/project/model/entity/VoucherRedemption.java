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
@Table(name = "voucher_redemptions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoucherRedemption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long redemptionId;

    @ManyToOne
    @JoinColumn(name = "voucher_instance_id", referencedColumnName = "voucher_instance_id")
    private VoucherInstance voucherInstance;

    @Column(name = "redemption_date")
    private LocalDateTime redemptionDate;

    @Column(name = "location", length = 45)
    private String location;

    @Column(name = "status", length = 45)
    private String status;

    @Column(name = "initial_amount", length = 45)
    private String initialAmount;

    @Column(name = "discount_amount", length = 45)
    private String discountAmount;

    @Column(name = "final_amount", length = 45)
    private String finalAmount;
}
