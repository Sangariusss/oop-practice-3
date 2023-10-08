package com.sangarius.opp.practice3.persistence.entity.exceptions;

public class MissingRequiredFieldException extends RuntimeException {

    public MissingRequiredFieldException(String message) {
        super(message);
    }
}

