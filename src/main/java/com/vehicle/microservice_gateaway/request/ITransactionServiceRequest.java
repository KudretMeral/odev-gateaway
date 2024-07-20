package com.vehicle.microservice_gateaway.request;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ITransactionServiceRequest {


    @POST("/api/transaction/createTransaction")
    Call<JsonElement> createTransaction(@Body JsonElement requestBody);

    @DELETE("/api/transaction/deleteTransaction/{transactionId}")
    Call<Void> deleteTransaction(@Path("transactionId") Long transactionId);

    @GET("/api/transaction/getAllTransactionsOfUser/{userId}")
    Call<List<JsonElement>> getAllTransactionsOfUser(@Path("userId") Long userId);
}

