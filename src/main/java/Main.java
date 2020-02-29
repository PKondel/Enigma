import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    String resourcePath = "/fxml/Main.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(resourcePath));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Enigma");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
