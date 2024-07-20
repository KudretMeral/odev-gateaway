package com.vehicle.microservice_gateaway.service;

import com.google.gson.JsonElement;

import java.util.List;

public interface IVehicleService {
    JsonElement createVehicle(JsonElement requestBody);

    void deleteVehicle(Long productId);

    List<JsonElement> getAllVehicle();
}
