package com.rpa.ppmtickethelperservice.core.exception;

/**
 * Created by jespinosa on 11/07/2018.
 */
public class EncryptException extends TicketHelperServiceException {

    public String getCode(){
        return ErrorCode.ENCRYPT;
    }

    public EncryptException()
    {
        super(ErrorMessage.ENCRYPT_ERROR);
    }

    public EncryptException(String message)
    {
        super(message);
    }

    public EncryptException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public EncryptException(Throwable cause)
    {
        super(cause);
    }
}
