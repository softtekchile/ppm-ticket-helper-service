package com.rpa.ppmtickethelperservice.service;

import com.rpa.ppmtickethelperservice.business.ProcessTicketData;
import com.rpa.ppmtickethelperservice.core.exception.ErrorCode;
import com.rpa.ppmtickethelperservice.core.exception.ErrorMessage;
import com.rpa.ppmtickethelperservice.core.exception.TicketHelperServiceException;
import com.rpa.ppmtickethelperservice.entities.request.ProcessTicketRequest;
import com.rpa.ppmtickethelperservice.entities.response.ErrorResponse;
import com.rpa.ppmtickethelperservice.entities.response.ProcessTicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ticketService")
public class TicketHelperRestService {

    @Autowired
    @Qualifier("processTicketDataImpl")
    private ProcessTicketData processTicketData;

    @PostMapping (value = "/getTicketData")
    public ProcessTicketResponse getTicketData(@RequestBody ProcessTicketRequest request) throws TicketHelperServiceException {

        ProcessTicketResponse response = processTicketData.getTicketData(request);

        return response;
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    ErrorResponse handleException(Exception ex)
    {

        ErrorResponse errorResponse = new ErrorResponse();

        String code = (ex instanceof TicketHelperServiceException) ? ((TicketHelperServiceException) ex).getCode() : ErrorCode.UNEXPECTED_ERROR;
        String message = (ex instanceof TicketHelperServiceException) ? ex.getMessage() : ErrorMessage.UNEXPECTED_ERROR;

        errorResponse.setCode(code);
        errorResponse.setMessage(message);
        return errorResponse;
    }
}
