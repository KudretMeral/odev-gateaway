package com.vehicle.microservice_gateaway.service;

import com.vehicle.microservice_gateaway.entity.AplUser;

import java.util.List;
import java.util.Optional;

public interface IAplUserService {
    AplUser saveUser(AplUser user);

    Optional<AplUser> findByUsername(String username);

    List<AplUser> findAllUsers();
}
