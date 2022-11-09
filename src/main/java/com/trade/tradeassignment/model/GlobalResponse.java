package com.trade.tradeassignment.model;


public class GlobalResponse {

    private boolean success = true;
    private String message;

    public GlobalResponse() {
    }

    public GlobalResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public GlobalResponse setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public GlobalResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}
