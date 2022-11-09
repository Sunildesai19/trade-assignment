package com.trade.tradeassignment;

import com.trade.tradeassignment.entity.TransactionEntity;
import com.trade.tradeassignment.model.TransactionRequest;

import java.util.Optional;

public class MockedEntities {
    public static Optional<TransactionEntity> getMockedTransactionEntity() {
        TransactionEntity entity = new TransactionEntity();
        entity.setTradeId("T1");
        entity.setVersion(2);
        entity.setBookId("B1");
        entity.setExpired("N");
        entity.setCreatedDate("05/12/2022");
        entity.setMaturityDate("06/12/2022");
        entity.setCounterPartyId("CP-1");
        return Optional.of(entity);
    }

    public static TransactionRequest getMockedTransactionRequest() {
        TransactionRequest request=new TransactionRequest();
        request.setTradeId("T1");
        request.setVersion(2);
        request.setBookId("B1");
        request.setExpired("N");
        request.setCreatedDate("05/12/2022");
        request.setMaturityDate("06/12/2022");
        request.setCounterPartyId("CP-1");
        return request;
    }

    public static TransactionRequest getMockedInvalidVersionRequest() {
        TransactionRequest request=new TransactionRequest();
        request.setTradeId("T1");
        request.setVersion(1);
        request.setBookId("B1");
        request.setExpired("N");
        request.setCreatedDate("05/12/2022");
        request.setMaturityDate("06/12/2022");
        request.setCounterPartyId("CP-1");
        return request;
    }

    public static TransactionRequest getMockedInvalidMaturityDateRequest() {
        TransactionRequest request=new TransactionRequest();
        request.setTradeId("T1");
        request.setVersion(1);
        request.setBookId("B1");
        request.setExpired("N");
        request.setCreatedDate("05/12/2022");
        request.setMaturityDate("06/10/2022");
        request.setCounterPartyId("CP-1");
        return request;
    }
}
