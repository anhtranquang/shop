package com.digital.shop.exeption;

import com.digital.shop.controller.response.ResponseStatusEnum;

public class BadRequestValidationException extends ValidationException {
    private static final long serialVersionUID = 7801285763735533554L;

    public BadRequestValidationException(ResponseStatusEnum errorStatus, String... params) {
        super(errorStatus, params);
    }
}
