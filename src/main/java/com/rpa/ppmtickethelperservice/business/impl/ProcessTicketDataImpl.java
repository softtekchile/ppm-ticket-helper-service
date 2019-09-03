package com.rpa.ppmtickethelperservice.business.impl;

import com.rpa.ppmtickethelperservice.entities.request.ProcessTicketRequest;
import com.rpa.ppmtickethelperservice.entities.response.ProcessTicketResponse;
import org.springframework.stereotype.Component;

@Component("processTicketDataImpl")
public class ProcessTicketDataImpl implements com.rpa.ppmtickethelperservice.business.ProcessTicketData {

    @Override
    public ProcessTicketResponse getTicketData(ProcessTicketRequest request)
            throws Exception
    {

        ProcessTicketResponse response = new ProcessTicketResponse();

        response.setNroSolicitud(request.toString());
        return response;
    }
}
