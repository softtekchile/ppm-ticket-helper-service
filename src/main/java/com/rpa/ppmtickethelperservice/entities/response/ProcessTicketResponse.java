package com.rpa.ppmtickethelperservice.entities.response;

import com.rpa.ppmtickethelperservice.entities.dto.TicketPPM;

public class ProcessTicketResponse {
    private String nroSolicitud;

    public String getNroSolicitud() {
        return nroSolicitud;
    }

    public void setNroSolicitud(String nroSolicitud) {
        this.nroSolicitud = nroSolicitud;
    }

    @Override
    public String toString() {
        return "ProcessTicketResponse{" +
                "nroSolicitud='" + nroSolicitud + '\'' +
                '}';
    }
}
