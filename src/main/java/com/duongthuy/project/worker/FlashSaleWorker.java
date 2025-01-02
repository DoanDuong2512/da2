package com.duongthuy.project.worker;

import com.duongthuy.project.dto.request.FlashSaleQueueRequest;
import com.duongthuy.project.dto.request.ParticipateFlashSaleRequest;
import com.duongthuy.project.service.FlashSaleService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlashSaleWorker {
  private final FlashSaleService flashSaleService;
  private final FlashSaleQueueService queueService;
  private final int numberOfWorkers = 5;

  @PostConstruct
  public void init() {
    for (int i = 0; i < numberOfWorkers; i++) {
      new Thread(this::processRequests, "FlashSaleWorker-" + i).start();
    }
  }

  private void processRequests() {
    while (true) {
      try {
        FlashSaleQueueRequest request = queueService.takeRequest();
        flashSaleService.processFlashSaleRequest(request.getFlashSaleRequest(), request.getUser());
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        break;
      }
    }
  }
}
