package factories;

import ciphers.Cipher;

public interface CipherFactory {
    Cipher create(String type);
}
