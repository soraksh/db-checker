package com.soraksh.dbchecker.rest.exception;

public class ExceptionInfo {
    protected String exception;
    protected String message;

    public ExceptionInfo(String exception, String message) {
        this.exception = exception;
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }
}
