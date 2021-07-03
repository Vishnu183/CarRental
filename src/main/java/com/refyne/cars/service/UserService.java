package com.refyne.cars.service;

import com.refyne.cars.entity.User;
import com.refyne.cars.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void create(String mobileNumber){
        Assert.isTrue(!userRepository.findByMobileNumber(mobileNumber).isPresent(), "User already present");
        User user = new User();
        user.setMobileNumber(mobileNumber);
        userRepository.save(user);
    }
}
