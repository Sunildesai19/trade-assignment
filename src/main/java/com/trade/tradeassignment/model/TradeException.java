package com.trade.tradeassignment.model;

public class TradeException extends Exception{
   // private final ErrorDescription errorDescription;

    private String message;
    public TradeException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    /* public TradeException(ErrorDescription errorDescription) {
        super(errorDescription.getMessage());
        this.errorDescription = errorDescription;
    }

    public ErrorDescription getErrorDescription() {
        return errorDescription;
    }*/
}
