package com.xcodel.commons.secret;

import org.junit.Assert;
import org.junit.Test;

public class SecretProviderTest {

    @Test
    public void givenString_whenEncrypt_thenSuccess() {


        String input = "M8yd1NltizBMHH7GB535H9X4Z6ozQYg0X9dZ5gPgjm+u5ZKRMQ9dlJbDkO07mUEQ";
        String cipherText = SecretUtil.encode(input);
        String plainText = SecretUtil.decode(cipherText);

        String cipherTextLow = SecretUtil.encode(input);
        String plainTextLow = SecretUtil.decode(cipherTextLow);

        Assert.assertEquals(input, plainText);
        Assert.assertEquals(input, plainTextLow);
    }

}