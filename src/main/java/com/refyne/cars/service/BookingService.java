package com.refyne.cars.service;

import com.refyne.cars.dto.BookingDetail;
import com.refyne.cars.dto.BookingDto;
import com.refyne.cars.entity.Booking;
import com.refyne.cars.entity.User;
import com.refyne.cars.repo.BookingRepository;
import com.refyne.cars.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private CarService carService;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    public Booking createBooking(BookingDto bookingDto) throws Exception {
        Booking activeBooking = bookingRepository.getActiveBooking(bookingDto.getCarId());
        Assert.isNull(activeBooking, "This car is not available for booking");
        Booking booking = Booking.fromDto(bookingDto);
        booking.setPrice(carService.getPrice(booking.getCarId(), booking.getStartTime(), booking.getEndTime()).getPrice());
        return bookingRepository.save(Booking.fromDto(bookingDto));
    }

    public List<BookingDetail> getBookingsByCar(String carId){
        List<Booking> bookings = bookingRepository.findAllByCarId(carId);
        List<BookingDetail> bookingDetails = new ArrayList<>();
        bookings.forEach(booking -> {
            User user = userRepository.getById(booking.getUserId());
            BookingDetail bookingDetail = new BookingDetail();
            bookingDetail.setUser(user);
            bookingDetail.setStartTime(booking.getStartTime());
            bookingDetail.setEndTime(booking.getEndTime());
            bookingDetails.add(bookingDetail);
        });
        return bookingDetails;
    }

    public List<Booking> getBookingsByUserId(Long userId){
        return bookingRepository.findAllByUserId(userId);
    }

}
