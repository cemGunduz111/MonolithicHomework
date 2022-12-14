package com.cem.monolithichomework.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorType {

    USER_NOT_FOUND(1000,"Aramakta olduğunuz kullanıcı sistemde kayıtlı değil",INTERNAL_SERVER_ERROR),
    USER_NOT_CREATED(1001,"Kullanıcı kaydedilemedi",INTERNAL_SERVER_ERROR);
    private int code;
    private String message;
    HttpStatus httpStatus;
}
