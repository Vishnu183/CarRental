package com.refyne.cars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
public class CarRequestDto {

    @JsonProperty("car_license_number")
    private String carLicenseNumber;

    @NonNull
    private String manufacturer;

    @NonNull
    private String model;

    @NonNull
    private Double basePrice;

    @NonNull
    private Double php;

    @NonNull
    @JsonProperty("security_deposit")
    private Double securityDeposit;
}
