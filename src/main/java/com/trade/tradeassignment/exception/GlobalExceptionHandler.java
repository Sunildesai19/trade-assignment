package com.trade.tradeassignment.exception;

import com.trade.tradeassignment.model.GlobalResponse;
import com.trade.tradeassignment.model.TradeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    public static final Logger logg = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({TradeException.class})
    public ResponseEntity<Object> handleTradeException(TradeException ex) {
        logg.error(ex.getMessage(), ex);
        return buildErrorResponse(ex.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleException(Exception ex) {
        logg.error(ex.getMessage(), ex);
        return buildErrorResponse("Something went wrong");
    }

    private ResponseEntity<Object> buildErrorResponse(String message) {
        GlobalResponse response = new GlobalResponse();
        response.setSuccess(false);
        response.setMessage(message);
        return ResponseEntity.ok(response);
    }

}
