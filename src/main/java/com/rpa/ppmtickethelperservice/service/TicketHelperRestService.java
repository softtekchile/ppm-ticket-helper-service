package com.rpa.ppmtickethelperservice.service;

import com.rpa.ppmtickethelperservice.business.ProcessTicketData;
import com.rpa.ppmtickethelperservice.entities.request.ProcessTicketRequest;
import com.rpa.ppmtickethelperservice.entities.response.ProcessTicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ticketService")
public class TicketHelperRestService {

    @Autowired
    @Qualifier("processTicketDataImpl")
    private ProcessTicketData processTicketData;

    @PostMapping (value = "/getTicketData")
    public ProcessTicketResponse getTicketData(@RequestBody ProcessTicketRequest request) throws Exception {

        ProcessTicketResponse response = processTicketData.getTicketData(request);

        return response;
    }
}
