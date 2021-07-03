package com.refyne.cars.service;

import com.refyne.cars.dto.CarRequestDto;
import com.refyne.cars.dto.PriceDto;
import com.refyne.cars.entity.Car;
import com.refyne.cars.repo.BookingRepository;
import com.refyne.cars.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public void create(CarRequestDto carRequestDto){
        carRepository.save(Car.fromDto(carRequestDto));
    }

    public List<Car> getAvailableCars(LocalDateTime startTime, LocalDateTime endTime){
        List<String> carIds = bookingRepository.getActiveBookingsInGivenTimeRange(startTime, endTime);
        return carRepository.getCarsByIdNotContaining(carIds);
    }

    public PriceDto getPrice(String carId, LocalDateTime from, LocalDateTime to) throws Exception {
        Optional<Car> carOptional = carRepository.findByCarLicenseNumber(carId);
        if(!carOptional.isPresent())
            throw new Exception("No Car found with id : "+carId);
        Car car = carOptional.get();

        long hours = ChronoUnit.HOURS.between(from, to);

        Double price = car.getBasePrice() + car.getPhp()*hours ;

        return new PriceDto(car.getCarLicenseNumber(), price, car.getSecurityDeposit(), from, to);
    }
}
