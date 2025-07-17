package com.example.bookstore.exception;

public class BookErrorResponse {

    public int status;
    public String message;
    public long timestamp;

    public BookErrorResponse(String message, int status) {
        this.message = message;
        this.timestamp = System.currentTimeMillis();
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = System.currentTimeMillis();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
