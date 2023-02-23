package com.digital.shop.factory;

import com.digital.shop.controller.response.ResponseStatusEnum;
import com.digital.shop.domain.GeneralResponse;
import com.digital.shop.domain.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseFactory {

    public ResponseEntity success() {
        GeneralResponse<Object> responseObject = new GeneralResponse();
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setCode(ResponseStatusEnum.SUCCESS.code());
        responseStatus.setMessage(ResponseStatusEnum.SUCCESS.message());
        responseObject.setStatus(responseStatus);
        return ResponseEntity.ok(responseObject);
    }

    public ResponseEntity success(Object data, Class clazz) {
        GeneralResponse<Object> responseObject = new GeneralResponse();
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setCode(ResponseStatusEnum.SUCCESS.code());
        responseStatus.setMessage(ResponseStatusEnum.SUCCESS.message());
        responseObject.setStatus(responseStatus);
        responseObject.setData(clazz.cast(data));
        return ResponseEntity.ok(responseObject);
    }

    public ResponseEntity error(HttpStatus httpStatus, String errorCode, String errorMessage) {
        ResponseStatus responseStatus = new ResponseStatus();
        GeneralResponse<Object> responseObject = new GeneralResponse();
        responseStatus.setCode(errorCode);
        responseStatus.setMessage(errorMessage);
        responseObject.setStatus(responseStatus);
        ResponseEntity responseEntity = new ResponseEntity(responseObject, httpStatus);
        return responseEntity;
    }

    public ResponseEntity error(HttpStatus httpStatus, ResponseStatusEnum status) {
        ResponseStatus responseStatus = new ResponseStatus();
        GeneralResponse<Object> responseObject = new GeneralResponse();
        responseStatus.setCode(status.code());
        responseStatus.setMessage(status.message());
        responseObject.setStatus(responseStatus);
        ResponseEntity responseEntity = new ResponseEntity(responseObject, httpStatus);
        return responseEntity;
    }

    public ResponseEntity error(HttpStatus httpStatus, ResponseStatusEnum status, Object data, Class clazz) {
        ResponseStatus responseStatus = new ResponseStatus();
        GeneralResponse<Object> responseObject = new GeneralResponse();
        responseStatus.setCode(status.code());
        responseStatus.setMessage(status.message());
        responseObject.setStatus(responseStatus);
        responseObject.setData(clazz.cast(data));
        return ResponseEntity.status(httpStatus).body(responseObject);
    }
}
