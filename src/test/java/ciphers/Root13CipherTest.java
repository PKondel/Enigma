package ciphers;

import ciphers.impl.Root13Cipher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Root13CipherTest {
    protected final String textWithNoAlphabeticLetters = "112312[]][";
    protected final String textWithAlphabeticLetters = "abcdd";
    protected final String expectedTextForAlphabeticLetters = "nopqq";
    protected final String mixedText = "123ac//";
    protected final String expectedTextForMixedText = "123np//";
    protected final String textWithUpperAndLowerLetters = "ABCabc";
    protected final String expectedTextWithUpperAndLowerLetters = "NOPnop";
    protected Cipher root13Cipher = new Root13Cipher();

    @DisplayName("Testing correction of encoding text with no alphabetic letters")
    @Test
    public void testIfOnlyAlphabeticLettersAreEncoded() {
        String encoded = root13Cipher.encode(textWithNoAlphabeticLetters);
        Assertions.assertEquals(textWithNoAlphabeticLetters, encoded);
    }

    @DisplayName("Testing correction of encoding text with alphabetic letters")
    @Test
    public void testIfEncodingModifyTextWithAlphabeticChars() {
        String encoded = root13Cipher.encode(textWithAlphabeticLetters);
        Assertions.assertEquals(expectedTextForAlphabeticLetters, encoded);
    }

    @DisplayName("Testing correction of encoding text with alphabetic and no alphabetic letters")
    @Test
    public void testIfAlphabeticAndNoAlphabeticLettersAreEncoded() {
        String encoded = root13Cipher.encode(mixedText);
        Assertions.assertEquals(expectedTextForMixedText, encoded);
    }

    @DisplayName("Testing correction of encoding text with upper and lower letters")
    @Test
    public void testIfUpperAndLowerLettersAreEncoded() {
        String encoded = root13Cipher.encode(textWithUpperAndLowerLetters);
        Assertions.assertEquals(expectedTextWithUpperAndLowerLetters, encoded);
    }

    @DisplayName("Testing correction of decoding text with no alphabetic letters")
    @Test
    public void testIfOnlyAlphabeticLettersAreDecoded() {
        String decoded = root13Cipher.decode(textWithNoAlphabeticLetters);
        Assertions.assertEquals(textWithNoAlphabeticLetters, decoded);
    }

    @DisplayName("Testing correction of decoding text with alphabetic letters")
    @Test
    public void testIfDecodingModifyTextWithAlphabeticChars() {
        String decoded = root13Cipher.decode(expectedTextForAlphabeticLetters);
        Assertions.assertEquals(textWithAlphabeticLetters, decoded);
    }

    @DisplayName("Testing correction of decoding text with alphabetic and no alphabetic letters")
    @Test
    public void testIfAlphabeticAndNoAlphabeticLettersAreDecoded() {
        String decoded = root13Cipher.decode(expectedTextForMixedText);
        Assertions.assertEquals(mixedText, decoded);
    }

    @DisplayName("Testing correction of decoding text with upper and lower letters")
    @Test
    public void testIfUpperAndLowerLettersAreDecoded() {
        String decoded = root13Cipher.decode(expectedTextWithUpperAndLowerLetters);
        Assertions.assertEquals(textWithUpperAndLowerLetters, decoded);
    }
}
