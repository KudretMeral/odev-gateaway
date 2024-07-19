package com.vehicle.microservice_gateaway.service;

import com.vehicle.microservice_gateaway.entity.AplUser;

public interface IAuthenticationService {
    String signInAndReturnJWT(AplUser signInRequest);
}
