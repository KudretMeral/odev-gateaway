package com.vehicle.microservice_gateaway.request;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface IVehicleServiceRequest {

    @POST("/api/vehicle/createVehicle")
    Call<JsonElement> createVehicle(@Body JsonElement requestBody);

    @DELETE("/api/vehicle/deleteVehicle/{id}")
    Call<Void> deleteVehicle(@Path("id") Long productId);

    @GET("/api/vehicle/getAllVehicle")
    Call<List<JsonElement>> getAllVehicle();
}
