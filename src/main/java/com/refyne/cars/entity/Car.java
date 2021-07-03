package com.refyne.cars.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.refyne.cars.dto.CarRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    @JsonProperty("car_license_number")
    @Id
    @Column(unique = true)
    private String carLicenseNumber;

    private String manufacturer;

    private String model;

    private Double basePrice;

    private Double php;

    @JsonProperty("security_deposit")
    private Double securityDeposit;

    public static Car fromDto(CarRequestDto requestDto) {
        return Car.builder()
                .carLicenseNumber(requestDto.getCarLicenseNumber())
                .manufacturer(requestDto.getManufacturer())
                .model(requestDto.getModel())
                .basePrice(requestDto.getBasePrice())
                .php(requestDto.getPhp())
                .securityDeposit(requestDto.getSecurityDeposit())
                .build();
    }

}
