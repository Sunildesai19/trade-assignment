package com.trade.tradeassignment.scheduler;


import com.trade.tradeassignment.entity.TransactionEntity;
import com.trade.tradeassignment.model.TradeException;
import com.trade.tradeassignment.repository.TransactionRepository;
import com.trade.tradeassignment.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Component
public class UpdateExpiredFlag {

    @Autowired
    private TransactionRepository repository;

    @Scheduled(cron = "@hourly")
    public void clearCacheMap() throws TradeException, ParseException {
        Optional<List<TransactionEntity>> optionalEntityList = Optional.of(repository.findAll());
        if(optionalEntityList.isPresent()){
            for(TransactionEntity t : optionalEntityList.get()){
                if(TransactionUtil.isExpired(t.getMaturityDate(),t.getCreatedDate())){
                    t.setExpired("Y");
                    repository.save(t);
                }
            }
        }

    }
}
