package com.example.apijwt.handler;

import java.io.Serializable;

/**
 * @author Walter Porfirio
 *
 */
public class ErrorMgs implements Serializable {

    private static final long serialVersionUID = 4575566687349763250L;

    private String message;

    private int errorCode;

    public ErrorMgs() {
        super();
    }

    public ErrorMgs(String message, int errorCode) {
        super();
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

}