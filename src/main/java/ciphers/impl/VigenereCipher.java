package ciphers.impl;

import ciphers.Cipher;

public class VigenereCipher implements Cipher {
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private String key;

    @Override
    public String encode(String textToEncode) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < textToEncode.length(); i++) {
            char sign = textToEncode.charAt(i);
            if (ALPHABET.contains(String.valueOf(sign).toLowerCase())) {
                boolean isLowerCase = Character.isLowerCase(sign);
                sign = Character.toLowerCase(sign);
                int index = (ALPHABET.indexOf(key.charAt(i % key.length())) + ALPHABET.indexOf(Character.toLowerCase(sign))) % 26;
                stringBuilder.append(isLowerCase ? ALPHABET.charAt(index) : Character.toUpperCase(ALPHABET.charAt(index)));
            } else {
                stringBuilder.append(sign);
            }
        }
        return stringBuilder.toString();
    }


    @Override
    public String decode(String textToDecode) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < textToDecode.length(); i++) {
            char sign = textToDecode.charAt(i);
            if (ALPHABET.contains(String.valueOf(sign).toLowerCase())) {
                boolean isLowerCase = Character.isLowerCase(sign);
                sign = Character.toLowerCase(sign);
                int index = (ALPHABET.indexOf(Character.toLowerCase(sign)) + 26 - (ALPHABET.indexOf(key.charAt(i % key.length())))) % 26;
                stringBuilder.append(isLowerCase ? ALPHABET.charAt(index) : Character.toUpperCase(ALPHABET.charAt(index)));
            } else {
                stringBuilder.append(sign);
            }
        }
        return stringBuilder.toString();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key.toLowerCase();
    }
}
