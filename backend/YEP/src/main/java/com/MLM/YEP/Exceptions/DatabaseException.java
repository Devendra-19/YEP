package com.MLM.YEP.Exceptions;

import java.io.IOException;

public class DatabaseException extends IOException {
    public DatabaseException(String message){
        super(message) ;
    }
}
