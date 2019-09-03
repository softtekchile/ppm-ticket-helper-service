package com.rpa.ppmtickethelperservice.business.impl;

import com.rpa.ppmtickethelperservice.core.exception.EncryptException;
import com.rpa.ppmtickethelperservice.core.exception.TicketHelperServiceException;
import com.rpa.ppmtickethelperservice.core.util.DecrypterUtil;
import com.rpa.ppmtickethelperservice.entities.constant.Constants;
import com.rpa.ppmtickethelperservice.entities.request.ProcessTicketRequest;
import com.rpa.ppmtickethelperservice.entities.response.ProcessTicketResponse;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("processTicketDataImpl")
public class ProcessTicketDataImpl implements com.rpa.ppmtickethelperservice.business.ProcessTicketData {

    @Override
    public ProcessTicketResponse getTicketData(ProcessTicketRequest request)
            throws TicketHelperServiceException
    {

        ProcessTicketResponse response = new ProcessTicketResponse();

        String decryptedPw = null;
        try {
            decryptedPw = DecrypterUtil.decrypt(request.getAuth().getEncryptedPw());
        } catch (Exception e) {
            e.printStackTrace();
            throw new EncryptException();
        }
        response.setNroSolicitud(decryptedPw);
        return response;
    }
}
