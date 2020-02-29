package controllers;

import ciphers.Cipher;
import ciphers.impl.CesarCipher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public TextArea textArea;

    @FXML
    public void triggerEncoding() {
        String userText = textArea.getText();
        if (!userText.isEmpty()) {
            Cipher ceserCipher = new CesarCipher();
            String encode = ceserCipher.encode(userText);
            textArea.setText(encode);
        }
    }

    @FXML
    public void triggerDecoding() {
        String userText = textArea.getText();
        if (!userText.isEmpty()) {
            Cipher cesarCipher = new CesarCipher();
            String decode = cesarCipher.decode(userText);
            textArea.setText(decode);
        }
    }
}
