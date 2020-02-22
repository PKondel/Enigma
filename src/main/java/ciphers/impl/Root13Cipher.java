package ciphers.impl;

import ciphers.Cipher;

public class Root13Cipher implements Cipher {

    private final String ALPHABET = new String("abcdefghijklmnopqrstuvwxyz");
    private final int ROOT_DISPLACEMENT = 13;

    @Override
    public String encode(String textToEncode) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < textToEncode.length(); i++) {
            char sign = textToEncode.charAt(i);
            if (isIncluded(sign)) {
                boolean isLowerCase = Character.isLowerCase(sign);
                int indexInAlphabet = ALPHABET.indexOf(Character.toLowerCase(sign));
                int indexAfterDisplacement = (indexInAlphabet + ROOT_DISPLACEMENT) % ALPHABET.length();
                if (isLowerCase) {
                    stringBuilder.append(ALPHABET.charAt(indexAfterDisplacement));
                } else {
                    stringBuilder.append(Character.toUpperCase(ALPHABET.charAt(indexAfterDisplacement)));
                }
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
            if (isIncluded(sign)) {
                boolean isLowerCase = Character.isLowerCase(sign);
                int indexInAlphabet = ALPHABET.indexOf(Character.toLowerCase(sign));
                int indexAfterDisplacement = (indexInAlphabet - ROOT_DISPLACEMENT + ALPHABET.length()) % ALPHABET.length();
                if (isLowerCase) {
                    stringBuilder.append(ALPHABET.charAt(indexAfterDisplacement));
                } else {
                    stringBuilder.append(Character.toUpperCase(ALPHABET.charAt(indexAfterDisplacement)));
                }
            } else {
                stringBuilder.append(sign);
            }
        }
        return stringBuilder.toString();
    }

    private boolean isIncluded(char sing) {
        return ALPHABET.contains(Character.toString(sing).toLowerCase());
    }
}
