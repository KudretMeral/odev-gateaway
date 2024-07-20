package com.vehicle.microservice_gateaway.service;

import com.google.gson.JsonElement;
import com.vehicle.microservice_gateaway.request.IVehicleServiceRequest;
import com.vehicle.microservice_gateaway.util.RetrofitUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VehicleService implements IVehicleService{

    @Autowired
    private IVehicleServiceRequest vehicleServiceRequest;

    @Override
    public JsonElement createVehicle(JsonElement requestBody)
    {
        return RetrofitUtils.executeInBlock(vehicleServiceRequest.createVehicle(requestBody));
    }

    @Override
    public void deleteVehicle(Long productId)
    {
        RetrofitUtils.executeInBlock(vehicleServiceRequest.deleteVehicle(productId));
    }

    @Override
    public List<JsonElement> getAllVehicle()
    {
        return RetrofitUtils.executeInBlock(vehicleServiceRequest.getAllVehicle());
    }
}
