package com.vehicle.microservice_gateaway.controller;

import com.google.gson.JsonElement;
import com.vehicle.microservice_gateaway.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gateway/vehicle")
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody JsonElement vehicle)
    {
        return ResponseEntity.ok(vehicleService.createVehicle(vehicle));
    }

    @DeleteMapping("{vehicleId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long vehicleId)
    {
        vehicleService.deleteVehicle(vehicleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllVehicle()
    {
        return ResponseEntity.ok(vehicleService.getAllVehicle());
    }
}
