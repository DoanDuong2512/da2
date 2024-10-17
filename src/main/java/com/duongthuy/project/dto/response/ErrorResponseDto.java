package com.duongthuy.project.dto.response;

public class ErrorResponseDto {
    private boolean success;
    private String message;
    private String errorCode;
    private Object data;


    public ErrorResponseDto() {
    }

    public ErrorResponseDto(boolean success, String message, String errorCode) {
        this.success = success;
        this.message = message;
        this.errorCode = errorCode;
    }

    // Getters and Setters

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() { return data; }

    public void setData(Object data) { this.data = data; }
}