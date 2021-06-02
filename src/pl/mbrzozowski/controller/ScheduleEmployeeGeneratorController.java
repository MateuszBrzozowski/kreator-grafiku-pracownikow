package pl.mbrzozowski.controller;

import javafx.css.Stylesheet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbrzozowski.helpers.PathToFXMLFile;
import pl.mbrzozowski.modelFx.EmployeeModel;
import pl.mbrzozowski.modelFx.ScheduleEmployeeGeneratorModel;

import java.io.IOException;
import java.util.Optional;
import java.util.ResourceBundle;

public class ScheduleEmployeeGeneratorController {

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private static ScheduleEmployeeGeneratorModel scheduleEmployeeGeneratorModel;
    private Stage stageScheduleEmployeeGenerator;
    private int statusGenerator=1;

    @FXML
    private BorderPane borderPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    public Button buttonNext;


    @FXML
    public void initialize(){
        scheduleEmployeeGeneratorModel = new ScheduleEmployeeGeneratorModel(buttonNext,this);
        stageScheduleEmployeeGenerator = MainWindowController.getStageScheduleEmployeeGenerator();
        setCenter(PathToFXMLFile.CHOOSE_MONTH);
        borderPane.setPrefSize(BorderPane.USE_COMPUTED_SIZE,BorderPane.USE_COMPUTED_SIZE);

    }

    @FXML
    public void buttonCancel_Clicked(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Anulować?");
        alert.setHeaderText("Czy jesteś pewnien, że chcesz przerwać generwoanie grafiku?");
        alert.setContentText("Po anulowaniu wszystkie wprowadzone dane zostaną utracone i nie będzie możliwości ich odzyskanie\n\n");


        ButtonType buttonTypeYes = new ButtonType("Tak");
        ButtonType buttonTypeNo = new ButtonType("Nie");
        ButtonType buttonTypeCancel = new ButtonType("Anuluj", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeYes,buttonTypeNo,buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeYes){
            stageScheduleEmployeeGenerator.close();
        }
    }

    @FXML
    public void buttonNext_Clicekd() {
        switch (statusGenerator){
            case 1 -> {
                setCenter(PathToFXMLFile.CHOOSE_OPEN_TIME);
                stageScheduleEmployeeGenerator.close();
                stageScheduleEmployeeGenerator.show();
                statusGenerator++;
            }
            case 2 -> {
                setCenter(PathToFXMLFile.CHOOSE_WORKING_DAY);
                stageScheduleEmployeeGenerator.close();
                stageScheduleEmployeeGenerator.show();
                statusGenerator++;
            }
            case 3 -> {
                scheduleEmployeeGeneratorModel.createSchedule();
            }
            default -> {
                logger.error("Status generatora nie prawidłowy");
                throw new IllegalStateException("Unexpected value: " + statusGenerator);
            }
        }
    }

    public static ScheduleEmployeeGeneratorModel getScheduleEmployeeGeneratorModel() {
        return scheduleEmployeeGeneratorModel;
    }

    public void setCenter(String fxmlPath){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
        loader.setResources(bundle);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            logger.error(String.valueOf(e));
        }
        borderPane.setCenter(root);
        borderPane.setPrefSize(BorderPane.USE_COMPUTED_SIZE, BorderPane.USE_COMPUTED_SIZE);
    }


}