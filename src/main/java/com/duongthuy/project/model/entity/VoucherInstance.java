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
@Table(name = "voucher_instances")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoucherInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voucherInstanceId;

    @ManyToOne
    @JoinColumn(name = "voucher_id", referencedColumnName = "voucher_id")
    private Voucher voucher;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

    @Column(name = "voucher_code", length = 50)
    private String voucherCode;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "purchase_at")
    private LocalDateTime purchaseAt;

    @Column(name = "used_at")
    private LocalDateTime usedAt;

    @Column(name = "status", length = 45)
    private String status;
}
