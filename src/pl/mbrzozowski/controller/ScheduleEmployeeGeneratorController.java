package pl.mbrzozowski.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Optional;
import java.util.ResourceBundle;

public class ScheduleEmployeeGeneratorController {

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());


    @FXML
    public void initialize(){

    }

    @FXML
    public void buttonCancel_Clicked(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Anulować?");
        alert.setHeaderText("Czy jesteś pewnien, że chcesz przerwać generwoanie grafiku?");
        alert.setContentText("Po anulowaniu wszystkie wprowadzone dane zostaną utracone i nie będzie możliwości ich odzyskanie\n\n\n");


        ButtonType buttonTypeYes = new ButtonType("Tak");
        ButtonType buttonTypeNo = new ButtonType("Nie");
        ButtonType buttonTypeCancel = new ButtonType("Anuluj", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeYes,buttonTypeNo,buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeYes){
            //TODO Anulowanie generowania grafiku - przerwij akcję
            logger.info("Yes");

        }else{
            //TODO - anulowanie anulowania generowania grafiku
            logger.info("Anulowano");
        }
    }

    @FXML
    public void buttonNext_Clicekd() {
    }

    public void setDialog(String fxmlPath){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
        loader.setResources(bundle);
        try {
            Parent root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}