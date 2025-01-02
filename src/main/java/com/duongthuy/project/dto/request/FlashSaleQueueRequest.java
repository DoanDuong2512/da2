package com.duongthuy.project.dto.request;

import com.duongthuy.project.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FlashSaleQueueRequest {
  ParticipateFlashSaleRequest flashSaleRequest;
  User user;
}
