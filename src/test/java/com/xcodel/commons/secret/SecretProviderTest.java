package com.xcodel.commons.secret;

import org.junit.Assert;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class SecretProviderTest {

    @Test
    public void givenString_whenEncrypt_thenSuccess()
            throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeySpecException {

        SecretKey key = SecretUtil.getKeyFromPassword("X)0DEL", "ledocx");

        String input = "Hi:I'm:EXCODEL";
        IvParameterSpec ivParameterSpec = SecretUtil.generateIv(true);
        String cipherText = SecretUtil.encrypt(input, key, ivParameterSpec);
        String plainText = SecretUtil.decrypt(cipherText, key, ivParameterSpec);

        String cipherTextLow = SecretUtil.encrypt(input, key);
        String plainTextLow = SecretUtil.decrypt(cipherTextLow, key);

        Assert.assertEquals(input, plainText);
        Assert.assertEquals(input, plainTextLow);
    }

}