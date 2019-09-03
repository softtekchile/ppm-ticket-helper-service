package com.rpa.ppmtickethelperservice.entities.dto;

public class Auth {
    private String mail;
    private String encryptedPw;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEncryptedPw() {
        return encryptedPw;
    }

    public void setEncryptedPw(String encryptedPw) {
        this.encryptedPw = encryptedPw;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "mail='" + mail + '\'' +
                ", encryptedPw='" + encryptedPw + '\'' +
                '}';
    }
}
