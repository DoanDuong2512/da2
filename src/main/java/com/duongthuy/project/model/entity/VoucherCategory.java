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
@Table(name = "voucher_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoucherCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voucherCategoryId;

    @Column(name = "voucher_category_name", length = 100)
    private String voucherCategoryName;

    @Column(name = "category_description", columnDefinition = "TEXT")
    private String categoryDescription;
}
