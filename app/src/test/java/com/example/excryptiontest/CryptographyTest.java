package com.example.excryptiontest;

import org.junit.Test;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import static org.junit.Assert.*;

public class CryptographyTest {
    @Test
    public void generateKeyPairEncryptAndDecryptTest() throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException {
        KeyPair keyPair = KeyGenerator.generateKeyPair();
        byte[] encryptedString = RSACipher.encrypt(keyPair.getPublic(), "Hello");
        String message = RSACipher.decrypt(keyPair.getPrivate(), encryptedString);
        assertEquals(message, "Hello");
    }
}
