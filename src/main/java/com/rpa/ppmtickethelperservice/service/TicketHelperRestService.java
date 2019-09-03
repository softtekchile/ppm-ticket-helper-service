package com.rpa.ppmtickethelperservice.controllers;

import com.rpa.ppmtickethelperservice.business.ProcessTicketData;
import com.rpa.ppmtickethelperservice.entities.dto.TicketPPM;
import com.rpa.ppmtickethelperservice.entities.request.ProcessTicketRequest;
import com.rpa.ppmtickethelperservice.entities.response.ProcessTicketResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ticketService")
public class TicketHelperRestService {

    private ProcessTicketData processTicketData;

    @PostMapping (value = "/getTicketData")
    public ProcessTicketResponse getTicketData(@RequestBody ProcessTicketRequest request) throws Exception {

        ProcessTicketResponse response = processTicketData.getTicketData(request);

        return response;
    }
}
