package com.trade.tradeassignment.util;

import com.trade.tradeassignment.entity.TransactionEntity;
import com.trade.tradeassignment.model.TradeException;
import com.trade.tradeassignment.model.TransactionRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionUtil {
    public static boolean validateMaturityDate(String date) throws TradeException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date maturityDate = sdf.parse(date);
        Date current = new Date();
         if(current.getTime() <= maturityDate.getTime())
            return true;
         else
             throw new TradeException("Invalid maturity date");
    }

    public static TransactionEntity mapToEntity(TransactionRequest transactionRequest, TransactionEntity entity) {
        entity.setTradeId(transactionRequest.getTradeId());
        entity.setVersion(transactionRequest.getVersion());
        entity.setBookId(transactionRequest.getBookId());
        entity.setExpired(transactionRequest.getExpired());
        entity.setCreatedDate(transactionRequest.getCreatedDate());
        entity.setMaturityDate(transactionRequest.getMaturityDate());
        entity.setCounterPartyId(transactionRequest.getCounterPartyId());
        return entity;
    }

    public static boolean isExpired(String mDate, String cDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date maturityDate = sdf.parse(mDate);
        Date CreatedDate = sdf.parse(cDate);
        if(maturityDate.getTime() < CreatedDate.getTime())
            return true;
        else
            return false;
    }
}
