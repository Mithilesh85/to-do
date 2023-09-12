package com.mithilesh.todo.exception;

import com.mithilesh.todo.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException exception){
        String message=exception.getMessage();
        ApiResponse apiResponse=new ApiResponse(message,false);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException exception){
        Map<String,String> validationErrors=new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((errors)->{
            String errorField = ((FieldError) errors).getField();
            String errorMessage = errors.getDefaultMessage();
            validationErrors.put(errorField,errorMessage);
        });
        return new ResponseEntity<Map<String,String>>(validationErrors,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse> handleApiException(ApiException exception){
        String message=exception.getMessage();
        ApiResponse apiResponse=new ApiResponse(message,false);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}
