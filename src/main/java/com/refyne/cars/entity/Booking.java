package com.refyne.cars.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.refyne.cars.dto.BookingDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("car_id")
    private String carId;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("start_time")
    private LocalDateTime startTime;

    @JsonProperty("end_time")
    private LocalDateTime endTime;

    private Double price;

    public static Booking fromDto(BookingDto requestDto) {
        return Booking.builder()
                .carId(requestDto.getCarId())
                .startTime(requestDto.getBookingStartTime())
                .endTime(requestDto.getBookingEndTime())
                .userId(requestDto.getUserId())
                .build();
    }
}
