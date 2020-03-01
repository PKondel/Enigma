package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.User;

public class RegisterUserController {

    @FXML
    TextField loginField;

    @FXML
    TextField passwordField;

    @FXML
    TextField emailField;

    @FXML
    public void registerUser() {
        User.UserBuilder builder = new User.UserBuilder();
        User user = builder.buildLogin(loginField.getText())
                .buildPassword(passwordField.getText())
                .buildEmail(emailField.getText())
                .build();
        System.out.println(user);
    }

    @FXML
    public void close() {

    }
}
