package com.rpa.ppmtickethelperservice.business.impl;

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

        byte[] base64Decrypted = Base64.getDecoder().decode(request.getAuth().getEncryptedPw());
        String decryptedPw = "";
        try {
            decryptedPw = DecrypterUtil.decrypt(base64Decrypted,Constants.ENCRYPTION_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setNroSolicitud(decryptedPw);
        return response;
    }
}
