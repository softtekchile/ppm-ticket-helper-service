package com.rpa.ppmtickethelperservice.business;

import com.rpa.ppmtickethelperservice.core.exception.TicketHelperServiceException;
import com.rpa.ppmtickethelperservice.entities.request.ProcessTicketRequest;
import com.rpa.ppmtickethelperservice.entities.response.ProcessTicketResponse;

public interface ProcessTicketData {

    ProcessTicketResponse getTicketData(ProcessTicketRequest req)
            throws TicketHelperServiceException;
}
