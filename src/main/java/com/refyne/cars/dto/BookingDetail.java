package com.refyne.cars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.refyne.cars.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BookingDetail {

    @JsonProperty("car_id")
    private String carId;

    @JsonProperty("user")
    private User user;

    @JsonProperty("start_time")
    private LocalDateTime startTime;

    @JsonProperty("end_time")
    private LocalDateTime endTime;

    private Double price;

}
