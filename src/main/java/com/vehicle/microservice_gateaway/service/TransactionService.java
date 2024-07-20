package com.vehicle.microservice_gateaway.service;

import com.google.gson.JsonElement;
import com.vehicle.microservice_gateaway.request.ITransactionServiceRequest;
import com.vehicle.microservice_gateaway.util.RetrofitUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService
{
    @Autowired
    private ITransactionServiceRequest transactionServiceRequest;

    @Override
    public JsonElement createTransaction(JsonElement transaction)
    {
        return RetrofitUtils.executeInBlock(transactionServiceRequest.createTransaction(transaction));
    }

    @Override
    public void deleteTransaction(Long transactionId)
    {
        RetrofitUtils.executeInBlock(transactionServiceRequest.deleteTransaction(transactionId));
    }

    @Override
    public List<JsonElement> getAllTransactionsOfUser(Long userId)
    {
        return RetrofitUtils.executeInBlock(transactionServiceRequest.getAllTransactionsOfUser(userId));
    }
}
