package com.trade.tradeassignment.service;

import com.trade.tradeassignment.MockedEntities;
import com.trade.tradeassignment.model.TradeException;
import com.trade.tradeassignment.model.TransactionRequest;
import com.trade.tradeassignment.model.TransactionResponse;
import com.trade.tradeassignment.repository.TransactionRepository;
import com.trade.tradeassignment.service.impl.TransactionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {
    @Mock
    private TransactionRepository repository;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Test
    void test_saveTransaction_existingRecord() {
        TransactionRequest request=MockedEntities.getMockedTransactionRequest();
        when(repository.findByTradeId(ArgumentMatchers.anyString()))
                .thenReturn(MockedEntities.getMockedTransactionEntity());
        try{
            TransactionResponse response=transactionService.saveTransaction(request);
            assertEquals(true,response.isSuccess());
        }catch(Exception e){
            assertTrue(false);
        }

    }

    @Test
    void test_saveTransaction_NewRecord() {
        TransactionRequest request=MockedEntities.getMockedTransactionRequest();
        when(repository.findByTradeId(ArgumentMatchers.anyString()))
                .thenReturn(Optional.empty());
        try{
            TransactionResponse response=transactionService.saveTransaction(request);
            assertEquals(true,response.isSuccess());
        }catch(Exception e){
            assertTrue(false);
        }

    }

    @Test
    void test_saveTransaction_InvalidVersion() throws ParseException {
        TransactionRequest request=MockedEntities.getMockedInvalidVersionRequest();
        when(repository.findByTradeId(ArgumentMatchers.anyString()))
                .thenReturn(MockedEntities.getMockedTransactionEntity());
        try{
            TransactionResponse response=transactionService.saveTransaction(request);
            assertTrue(false);
        }catch(TradeException e){
            assertEquals("Invalid version",e.getMessage());
        }
    }

    @Test
    void test_saveTransaction_InvalidMaturityDate() throws ParseException {
        TransactionRequest request=MockedEntities.getMockedInvalidMaturityDateRequest();
        when(repository.findByTradeId(ArgumentMatchers.anyString()))
                .thenReturn(Optional.empty());
        try{
            TransactionResponse response=transactionService.saveTransaction(request);
            assertTrue(false);
        }catch(TradeException e){
            assertEquals("Invalid maturity date",e.getMessage());
        }
    }

}
