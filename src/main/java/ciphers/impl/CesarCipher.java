package ciphers.impl;

import ciphers.Cipher;

public class CesarCipher implements Cipher {
    @Override
    public String encode(String textToEncode) {
        char[] textToEncodeInCharArray = textToEncode.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char sign : textToEncodeInCharArray) {
            if (Character.isAlphabetic(sign)) {
                boolean isUpperCase = Character.isUpperCase(sign);
                char codedLetter = Character.toUpperCase(sign);
                if (codedLetter < 88) {
                    codedLetter = (char) (codedLetter + 3);
                } else {
                    codedLetter = (char) (codedLetter - 23);
                }
                if (!isUpperCase) {
                    codedLetter = Character.toLowerCase(codedLetter);
                }
                stringBuilder.append(codedLetter);
            } else {
                stringBuilder.append(sign);
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String decode(String textToDecode) {
        char[] textToDecodeInCharArray = textToDecode.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char sign : textToDecodeInCharArray) {
            if (Character.isAlphabetic(sign)) {
                boolean isUpperCase = Character.isUpperCase(sign);
                char codedLetter = Character.toUpperCase(sign);
                if (codedLetter > 67) {
                    codedLetter = (char) (codedLetter - 3);
                } else {
                    codedLetter = (char) (codedLetter + 23);
                }
                if (!isUpperCase) {
                    codedLetter = Character.toLowerCase(codedLetter);
                }
                stringBuilder.append(codedLetter);
            } else {
                stringBuilder.append(sign);
            }
        }
        return stringBuilder.toString();
    }
}
