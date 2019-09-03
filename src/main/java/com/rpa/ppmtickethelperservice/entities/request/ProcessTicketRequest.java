package com.rpa.ppmtickethelperservice.entities.request;

import com.rpa.ppmtickethelperservice.entities.dto.Auth;
import com.rpa.ppmtickethelperservice.entities.dto.TicketPPM;

public class ProcessTicketRequest {
    private TicketPPM ticketPPM;
    private Auth auth;


    public TicketPPM getTicketPPM() {
        return ticketPPM;
    }

    public void setTicketPPM(TicketPPM ticketPPM) {
        this.ticketPPM = ticketPPM;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "ProcessTicketRequest{" +
                "ticketPPM=" + ticketPPM.toString() +
                ", auth=" + auth.toString() +
                '}';
    }
}
