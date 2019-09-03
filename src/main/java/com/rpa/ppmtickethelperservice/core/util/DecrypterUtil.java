package com.rpa.ppmtickethelperservice.core.util;
import com.rpa.ppmtickethelperservice.entities.constant.Constants;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DecrypterUtil {



    public static byte[] encrypt(String plainText, String encryptionKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/pkcs5padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(Constants.INITIALIZATIO_VECTOR.getBytes("UTF-8")));
        return cipher.doFinal(plainText.getBytes("UTF-8"));
    }

    public static String decrypt(String encryptedText) throws Exception{
        byte[] base64Decrypted = Base64.getDecoder().decode(encryptedText);


        Cipher cipher = Cipher.getInstance("AES/CBC/pkcs5padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(Constants.ENCRYPTION_KEY.getBytes("UTF-8"), "AES");
        cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(Constants.INITIALIZATIO_VECTOR.getBytes("UTF-8")));
        return new String(cipher.doFinal(base64Decrypted),"UTF-8");
    }

}


