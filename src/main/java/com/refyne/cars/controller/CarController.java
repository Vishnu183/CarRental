package com.refyne.cars.controller;

import com.refyne.cars.dto.CarRequestDto;
import com.refyne.cars.entity.Car;
import com.refyne.cars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/cars")
    public void create(@RequestBody CarRequestDto requestDto){
        carService.create(requestDto);
    }

    @GetMapping(value = "/search-cars")
    public List<Car> search(@RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime from,
                            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime to) {
        return carService.getAvailableCars(from, to);
    }

    @GetMapping(value = "/calculate-price/{carId}")
    public List<Car> getPrice(@PathVariable("carId") String carId,
                              @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime from,
                              @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime to) {
        return carService.getAvailableCars(from, to);
    }
}
