package com.cem.monolithichomework.exception;

import lombok.Getter;

@Getter
public class MonolithicHomeworkManagerException extends RuntimeException{
    /**
     * Uygulama içinde fırlatılacak olan özelleştirilmiş hatalar için kullanılacaktır.
     */
    private final ErrorType errorType;

    public MonolithicHomeworkManagerException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public MonolithicHomeworkManagerException(ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType = errorType;
    }

}
