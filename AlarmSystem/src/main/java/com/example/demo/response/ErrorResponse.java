package com.example.demo.response;

import com.example.demo.enums.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private int errorCode;
    private ErrorType errorType;
    private String message;
    private LocalDateTime timestamp;
    public ErrorResponse(int errorCode, ErrorType errorType, String message) {
        this.errorCode = errorCode;
        this.errorType = errorType;
        this.message = message;
        this.timestamp = LocalDateTime.now(); // Auto-generate timestamp
    }
}
