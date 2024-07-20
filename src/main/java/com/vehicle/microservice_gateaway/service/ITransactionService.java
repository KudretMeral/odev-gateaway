package com.vehicle.microservice_gateaway.service;

import com.google.gson.JsonElement;

import java.util.List;

public interface ITransactionService {
    JsonElement createTransaction(JsonElement transaction);

    void deleteTransaction(Long transactionId);

    List<JsonElement> getAllTransactionsOfUser(Long userId);
}
