package com.duongthuy.project.controller;

import com.duong.restful_api.model.dto.BookingDto;
import com.duong.restful_api.model.request.CreateBookingRequest;
import com.duong.restful_api.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("")
    public ResponseEntity<?> getListBooking() {
        List<BookingDto> bookings = bookingService.getListBookings();
        return ResponseEntity.ok(bookings);
    }

    @PostMapping("")
    public ResponseEntity<?> createBooking(@RequestBody CreateBookingRequest req) {
        BookingDto result = bookingService.createBooking(req);
        return ResponseEntity.ok(result);
    }
}
