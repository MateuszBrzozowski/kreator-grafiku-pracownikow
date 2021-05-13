package pl.mbrzozowski;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.mbrzozowski.controller.ChooseMonthController;
import pl.mbrzozowski.controller.MainWindowController;
import pl.mbrzozowski.controller.ScheduleEmployeeGeneratorController;
import pl.mbrzozowski.helpers.PathToFXMLFile;
import java.util.ResourceBundle;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(PathToFXMLFile.MAIN_WINDOW));
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
        loader.setResources(bundle);
        primaryStage.setTitle(bundle.getString("title.application"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
