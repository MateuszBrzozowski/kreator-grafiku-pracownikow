package pl.mbrzozowski;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = null;
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainWindow.fxml"));;
//        ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
//        primaryStage.setTitle(bundle.getString("title.application"));
//        fxmlLoader.setResources(bundle);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }


}
