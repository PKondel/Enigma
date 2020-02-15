package ciphers.impl;

public class Test {
    public static void main(String[] args) {
        String mama = "mama";
        char[] lettersInMamaWord = mama.toCharArray();

        for (char letter : lettersInMamaWord) {
            int newLetterNumber = letter + 3;
            System.out.print((char) newLetterNumber);
        }
        System.out.println();

        CesarCipher text = new CesarCipher();
        System.out.println(text.encode("ABCabc123XYZxyz"));
        System.out.println(text.decode("ABCabc123XYZxyz"));
    }
}
