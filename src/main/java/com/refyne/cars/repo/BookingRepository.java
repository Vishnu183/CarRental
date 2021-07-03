package com.refyne.cars.repo;

import com.refyne.cars.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {


    @Query(nativeQuery = true,
            value = "select * from bookings b where b.end_time > now()")
    Booking getActiveBooking(String carId);

    @Query("select b from Booking b where b.startTime <= ?1 and b.endTime >= ?2")
    List<String> getActiveBookingsInGivenTimeRange(LocalDateTime startTime, LocalDateTime endTIme);

    List<Booking> findAllByCarId(String carId);

    List<Booking> findAllByUserId(Long userId);
}
