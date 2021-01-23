package com.xcodel.commons.secret;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.crypto.Cipher;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SecretUtil {

    private static final String ENCRYPTION_KEY = "ABCDEFGHIJKLMNOP";
    private static final String CHARACTER_ENCODING = "UTF-8";
    private static final String CIPHER_TRANSFORMATION = "AES/CBC/PKCS5PADDING";
    private static final String ENCRYPTION_ALGORITHM = "AES";

    public static @NonNull String encode(@NonNull String phase) {
        try {
            Cipher cipher = getCipher(Cipher.ENCRYPT_MODE);
            byte[] cipherText = cipher.doFinal(phase.getBytes(StandardCharsets.UTF_8));
            Base64.Encoder encoder = Base64.getUrlEncoder();
            return encoder.encodeToString(cipherText);
        } catch (Exception e) {
            throw new RuntimeException("error occurred while encryption", e);
        }
    }

    private static Cipher getCipher(int encryptMode) throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
        byte[] key = ENCRYPTION_KEY.getBytes(CHARACTER_ENCODING);
        SecretKeySpec secretKey = new SecretKeySpec(key, ENCRYPTION_ALGORITHM);
        IvParameterSpec ivparameterspec = new IvParameterSpec(key);
        cipher.init(encryptMode, secretKey, ivparameterspec);
        return cipher;
    }

    public static @NonNull String decode(@NonNull String phase) {
        try {
            Cipher cipher = getCipher(Cipher.DECRYPT_MODE);
            Base64.Decoder decoder = Base64.getUrlDecoder();
            byte[] cipherText = decoder.decode(phase.getBytes(StandardCharsets.UTF_8));
            return new String(cipher.doFinal(cipherText), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("error occurred while decryption", e);
        }
    }

}
