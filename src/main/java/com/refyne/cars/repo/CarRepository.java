package com.refyne.cars.repo;


import com.refyne.cars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

    @Query("select c from Car c where c.carLicenseNumber not in (?1) ")
    List<Car> getCarsByIdNotContaining(List<String> ids);

    Optional<Car> findByCarLicenseNumber(String s);
}
