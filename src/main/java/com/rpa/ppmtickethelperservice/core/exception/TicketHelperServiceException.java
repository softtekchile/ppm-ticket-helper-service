package com.rpa.ppmtickethelperservice.core.exception;

/**
 * Base Business Exception
 */
public class TicketHelperServiceException extends Exception
{
    public String getCode()
    {
        return ErrorCode.BASE;
    }

    public TicketHelperServiceException()
    {
        super(ErrorMessage.BASE);
    }

    public TicketHelperServiceException(String message)
    {
        super(message);
    }

    public TicketHelperServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public TicketHelperServiceException(Throwable cause)
    {
        super(cause);
    }

}
