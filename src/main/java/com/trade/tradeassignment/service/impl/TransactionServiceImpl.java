package com.trade.tradeassignment.service.impl;

import com.trade.tradeassignment.entity.TransactionEntity;
import com.trade.tradeassignment.model.TradeException;
import com.trade.tradeassignment.model.TransactionRequest;
import com.trade.tradeassignment.model.TransactionResponse;
import com.trade.tradeassignment.repository.TransactionRepository;
import com.trade.tradeassignment.service.TransactionService;
import com.trade.tradeassignment.util.TransactionUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository repository;
    @Override
    public TransactionResponse saveTransaction(TransactionRequest transactionRequest) throws TradeException, ParseException {
        TransactionResponse response=new TransactionResponse();
        TransactionEntity entity=new TransactionEntity();

            Optional<TransactionEntity> optionalEntity = repository.findByTradeId(transactionRequest.getTradeId());
            if(optionalEntity.isPresent()){
                TransactionEntity transactionEntity = optionalEntity.get();
                if( transactionEntity.getVersion() > transactionRequest.getVersion()){
                    throw new TradeException("Invalid version");
                }else if(transactionEntity.getVersion() == transactionRequest.getVersion()){
                    transactionEntity=TransactionUtil.mapToEntity(transactionRequest, transactionEntity);
                    repository.save(transactionEntity);
                    response.setSuccess(true);
                    response.setMessage("Trade updated successfully");
                }else{
                    if(TransactionUtil.validateMaturityDate(transactionRequest.getMaturityDate())){
                        entity = TransactionUtil.mapToEntity(transactionRequest, entity);
                        repository.save(entity);
                        response.setMessage("Trade assigned successfully");
                    }
                }
            }else {
                if(TransactionUtil.validateMaturityDate(transactionRequest.getMaturityDate())){
                    entity = TransactionUtil.mapToEntity(transactionRequest, entity);
                    repository.save(entity);
                    response.setMessage("Trade assigned successfully");
                }
            }

       /* }catch(Exception e) {
            e.printStackTrace();
            throw new TradeException("Something went wrong");
        }*/
        response.setSuccess(true);

        return response;
    }
}
