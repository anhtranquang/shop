package com.digital.shop.exeption;

import com.digital.shop.controller.response.ResponseStatusEnum;

public class ValidationException extends RuntimeException {
    private static final long serialVersionUID = 7477925234189144413L;

    private ResponseStatusEnum errorStatus;
    private String[] params;

    public ValidationException(ResponseStatusEnum errorStatus, String... params) {
        super(String.format(errorStatus.message(), params));
        this.errorStatus = errorStatus;
        this.params = params;
    }

    public ResponseStatusEnum getErrorStatus() {
        return errorStatus;
    }

    public String[] getParams() {
        return params;
    }

    public String getErrorMessage() {
        return String.format(errorStatus.message(), params);
    }
}
