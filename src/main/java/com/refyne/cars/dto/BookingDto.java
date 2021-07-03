package com.refyne.cars.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BookingDto {

    private String carId;

    private LocalDateTime bookingStartTime;

    private LocalDateTime bookingEndTime;

    private Long userId;
}
