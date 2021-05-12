package pl.mbrzozowski.controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbrzozowski.modelFx.EmployeeModel;

public class EditEmployeeController extends EmployeeValues{

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private EmployeeModel employeeModel;

    @FXML
    public void initialize(){
        this.employeeModel = MainWindowController.getEmployeeModel();
        buttonDodaj.setDisable(true);
//        name = setName();
//        surname = setSurname();
//        sizeTime = setSizeTime();
//        position = setPosition();
        choiceBoxSizeTime.getItems().addAll(sizeTimeData);
        choiceBoxPosition.getItems().addAll(positionData);
        choiceBoxSizeTime.setOnAction(this::checkValues);
        choiceBoxPosition.setOnAction(this::checkValues);
        logger.info("Okno Edytuj pracownika zostało otwarte.");
    }

    @FXML
    public void buttonDodajClicked(MouseEvent event) {

    }

    @FXML
    void buttonAnulujClicked(MouseEvent event) {
        logger.info("Okno Edytuj pracownika zostało zamknięte.");
        Stage stage = ShowEmployeeController.getStageEditEmployee();
        stage.close();
    }

}
