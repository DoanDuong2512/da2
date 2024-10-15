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
@Table(name = "cart_item_vouchers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemVoucher {
    @ManyToOne
    @JoinColumn(name = "vouchers_voucher_id", referencedColumnName = "voucher_id")
    private Voucher voucher;

    @ManyToOne
    @JoinColumn(name = "cart_items_cart_item_id", referencedColumnName = "cart_item_id")
    private CartItem cartItem;
}
