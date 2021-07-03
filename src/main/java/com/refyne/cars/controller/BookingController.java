package com.refyne.cars.controller;

import com.refyne.cars.dto.BookingDetail;
import com.refyne.cars.dto.BookingDto;
import com.refyne.cars.entity.Booking;
import com.refyne.cars.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/car/book")
    public Booking create(BookingDto bookingDto) throws Exception {
        return bookingService.createBooking(bookingDto);
    }

    @GetMapping("/car/bookings")
    public List<BookingDetail> getBookingsByCar(String carId){
        return bookingService.getBookingsByCar(carId);
    }

    @GetMapping("/user/bookings")
    public List<Booking> getBookingsByUser(Long userId){
        return bookingService.getBookingsByUserId(userId);
    }
}
