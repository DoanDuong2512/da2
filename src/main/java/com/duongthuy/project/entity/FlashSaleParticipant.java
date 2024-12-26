package com.duongthuy.project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "flash_sale_participants")
public class FlashSaleParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flash_sale_participant_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "flash_sale_id", referencedColumnName = "flash_sale_id")
    private FlashSale flashSale;

    @ManyToOne
    private User user;

    @Column(name = "status")
    private String status;
}