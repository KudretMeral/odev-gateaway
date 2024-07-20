package com.vehicle.microservice_gateaway.controller;

import com.google.gson.JsonElement;
import com.vehicle.microservice_gateaway.security.UserPrincipal;
import com.vehicle.microservice_gateaway.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gateway/transaction")
public class TransactionController
{
    @Autowired
    private ITransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> saveTransaction(@RequestBody JsonElement transaction)
    {
        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    }

    @DeleteMapping("{transactionId}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long transactionId)
    {
        transactionService.deleteTransaction(transactionId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllTransactionsOfUser(@AuthenticationPrincipal UserPrincipal principal)
    {
        return ResponseEntity.ok(transactionService.getAllTransactionsOfUser(principal.getId()));
    }
}