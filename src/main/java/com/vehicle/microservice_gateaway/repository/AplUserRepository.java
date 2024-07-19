package com.vehicle.microservice_gateaway.repository;

import com.vehicle.microservice_gateaway.entity.AplUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AplUserRepository  extends JpaRepository<AplUser, Long> {
    Optional<AplUser> findByUsername(String username);
}
