package com.app.TestJava.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

public class MarvelAuthentication {
    private static String publicKey = "7de0a07897b8e56b7c99b8c5a8740055";
    private static String privateKey = "5f1040d9af2401040adc394489857e64c256414b";

    public static String generateHash() {
        String timestamp = String.valueOf(Instant.now());
        String dataToHash = timestamp + privateKey + publicKey;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(dataToHash.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating hash", e);
        }
    }
}
