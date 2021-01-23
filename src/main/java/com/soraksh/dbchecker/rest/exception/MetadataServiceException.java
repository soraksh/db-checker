package com.soraksh.dbchecker.rest.exception;

import java.sql.SQLException;

public class MetadataServiceException extends RuntimeException {

    protected String name;

    public MetadataServiceException(String message) {
        super(message);
        this.name = "MetadataServiceException";
    }

    public MetadataServiceException(SQLException e) {
        super("SQL Exception occurred. ErrorCode: "
                + e.getErrorCode()
                + "; Original error message: "
                + e.getMessage()
        );
        this.name = "SQLException";
    }

    public String getName() {
        return name;
    }
}
