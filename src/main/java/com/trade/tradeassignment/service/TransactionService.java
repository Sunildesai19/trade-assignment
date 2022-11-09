package com.trade.tradeassignment.service;

import com.trade.tradeassignment.model.TradeException;
import com.trade.tradeassignment.model.TransactionRequest;
import com.trade.tradeassignment.model.TransactionResponse;

import java.text.ParseException;

public interface TransactionService {
    TransactionResponse saveTransaction(TransactionRequest transactionRequest) throws TradeException, ParseException;
}
