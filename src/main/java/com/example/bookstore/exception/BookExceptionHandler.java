package com.example.bookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleBookNotFoundException(BookNotFoundException exception) {
        return new ResponseEntity<>(new BookErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleBookException(Exception exception) {
        return new ResponseEntity<>(new BookErrorResponse("Invalid Request", HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }
}
