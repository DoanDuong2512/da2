package com.duongthuy.project.worker;

import com.duongthuy.project.dto.request.FlashSaleQueueRequest;
import com.duongthuy.project.dto.request.ParticipateFlashSaleRequest;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.springframework.stereotype.Service;

@Service
public class FlashSaleQueueService {
  private final BlockingQueue<FlashSaleQueueRequest> queue = new LinkedBlockingQueue<>();

  public void addRequest(FlashSaleQueueRequest request) {
    queue.add(request);
  }

  public FlashSaleQueueRequest takeRequest() throws InterruptedException {
    return queue.take();
  }
}
