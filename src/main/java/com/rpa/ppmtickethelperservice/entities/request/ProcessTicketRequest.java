package com.rpa.ppmtickethelperservice.entities.request;

import com.rpa.ppmtickethelperservice.entities.dto.TicketPPM;

public class ProcessTicketRequest {
    private TicketPPM ticketPPM;

    public TicketPPM getTicketPPM() {
        return ticketPPM;
    }

    public void setTicketPPM(TicketPPM ticketPPM) {
        this.ticketPPM = ticketPPM;
    }

    @Override
    public String toString() {
        return "ProcessTicketRequest{" +
                "ticketPPM=" + ticketPPM +
                '}';
    }
}
