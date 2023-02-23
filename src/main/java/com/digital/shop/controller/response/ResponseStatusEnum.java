package com.digital.shop.controller.response;

public enum ResponseStatusEnum {
    SUCCESS("success", "Success"),
    GENERAL_ERROR("general_error", "Any error occur"),
    ERROR("error", "Any error occur"),
    SHOP_NOT_EXIST("invalid_request", "Shop does not exist"),;
    private String code;
    private String message;

    ResponseStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

}
