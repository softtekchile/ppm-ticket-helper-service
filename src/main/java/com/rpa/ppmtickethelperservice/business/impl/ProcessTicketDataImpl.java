package com.rpa.ppmtickethelperservice.business.impl;

import com.rpa.ppmtickethelperservice.business.automation.TicketAutomation;
import com.rpa.ppmtickethelperservice.core.exception.EncryptException;
import com.rpa.ppmtickethelperservice.core.exception.TicketHelperServiceException;
import com.rpa.ppmtickethelperservice.core.util.DecrypterUtil;
import com.rpa.ppmtickethelperservice.entities.dto.Auth;
import com.rpa.ppmtickethelperservice.entities.dto.TicketPPM;
import com.rpa.ppmtickethelperservice.entities.request.ProcessTicketRequest;
import com.rpa.ppmtickethelperservice.entities.response.ProcessTicketResponse;
import org.springframework.stereotype.Component;

@Component("processTicketDataImpl")
public class ProcessTicketDataImpl implements com.rpa.ppmtickethelperservice.business.ProcessTicketData {

    @Override
    public ProcessTicketResponse getTicketData(ProcessTicketRequest request)
            throws TicketHelperServiceException
    {

        ProcessTicketResponse response = new ProcessTicketResponse();

        TicketPPM ticketPPM = request.getTicketPPM();
        Auth auth = request.getAuth();
        String encrpyedPw;
        try {
            auth.setPw(DecrypterUtil.decrypt(auth.getEncryptedPw()));
            encrpyedPw = TicketAutomation.createTicket(ticketPPM, auth);

        } catch (Exception e) {
            e.printStackTrace();
            throw new EncryptException();
        }
        System.out.println("terminando creacion ticket");

        response.setNroSolicitud("123");
        return response;
    }
}
