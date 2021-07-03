package com.refyne.cars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto {

    @JsonProperty("name")
    private String carName;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("securityDeposit")
    private Double securityDeposit;

    private LocalDateTime from;

    private LocalDateTime to;
}
