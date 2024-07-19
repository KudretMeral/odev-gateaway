package com.vehicle.microservice_gateaway.service;

import com.vehicle.microservice_gateaway.entity.AplUser;
import com.vehicle.microservice_gateaway.repository.AplUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class AplUserService implements IAplUserService{

    @Autowired
    private AplUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public AplUser saveUser(AplUser user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreateTime(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public Optional<AplUser> findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<AplUser> findAllUsers()
    {
        return userRepository.findAll();
    }
}
