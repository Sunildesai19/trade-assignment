package com.trade.tradeassignment.controller;

import com.trade.tradeassignment.model.TradeException;
import com.trade.tradeassignment.model.TransactionResponse;
import com.trade.tradeassignment.model.TransactionRequest;
import com.trade.tradeassignment.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping("/assign")
    public ResponseEntity<TransactionResponse> createOrder(@RequestBody TransactionRequest transactionRequest) throws TradeException, ParseException {
        TransactionResponse response= service.saveTransaction(transactionRequest);
        return ResponseEntity.ok(response);
    }
}
