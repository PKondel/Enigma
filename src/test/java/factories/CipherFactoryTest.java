package factories;

import ciphers.Cipher;
import ciphers.impl.CesarCipher;
import ciphers.impl.Root13Cipher;
import exceptions.CipherNotFoundException;
import factories.impl.CipherFactoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CipherFactoryTest {
    private CipherFactory factory = new CipherFactoryImpl();
    private static final String MESSAGE = "Type of cipher is not recognized : ";

    @Test
    protected void ifCesarInstanceReturnedWithCesarTypeTest() {
        Cipher cipher = factory.create(CipherFactoryImpl.CESAR);
        Assertions.assertTrue(cipher instanceof CesarCipher);
    }

    @Test
    protected void ifRoot13InstanceReturnedWithRoot13TypeTest() {
        Cipher cipher = factory.create(CipherFactoryImpl.ROOT13);
        Assertions.assertTrue(cipher instanceof Root13Cipher);
    }

    @Test
    protected void shouldThrowExceptionWithGivenUnknownType() {
        String unknown = "unknown";
        Assertions.assertThrows(CipherNotFoundException.class, () -> factory.create(unknown), MESSAGE + unknown);
    }
}
