package com.example.excryptiontest;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class MainApplication extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        encryptAndDecryptUsingGeneratedKeys();

        encryptAndDecryptUsingKeyStore();
    }

    private void encryptAndDecryptUsingGeneratedKeys() {
        String text = "World!!";
        try {
            KeyPair keyPair = KeyGenerator.retrieveKeyPair();
            byte[] encryptedString = RSACipher.encrypt(keyPair.getPublic(), text);
            String message = RSACipher.decrypt(keyPair.getPrivate(), encryptedString);
            Log.d("TEST123", "message:" + message);
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | KeyStoreException | CertificateException | IOException | UnrecoverableKeyException e) {
            Log.e("TEST123", "", e);
        }
    }

    private void encryptAndDecryptUsingKeyStore() {
        String text = "Hello!!";
        try {
            KeyPair keyPair = KeyGenerator.generateKeyPair();
            byte[] encryptedString = RSACipher.encrypt(keyPair.getPublic(), text);
            String message = RSACipher.decrypt(keyPair.getPrivate(), encryptedString);
            Log.d("TEST123", "message:" + message);
        } catch (NoSuchProviderException | NoSuchAlgorithmException | InvalidAlgorithmParameterException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            Log.e("TEST123", "", e);
        }
    }
}
