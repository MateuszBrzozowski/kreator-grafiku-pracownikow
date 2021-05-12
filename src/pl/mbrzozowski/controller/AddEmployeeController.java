package pl.mbrzozowski.controller;

import javafx.beans.property.Property;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbrzozowski.modelFx.EmployeeModel;

public class AddEmployeeController extends EmployeeValues{

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @FXML
    private Button buttonAnuluj;

    private EmployeeModel employeeModel;

    public void initialize(){
        this.employeeModel =MainWindowController.getEmployeeModel();
        buttonDodaj.setDisable(true);
        choiceBoxSizeTime.setValue("Wysokość etatu");
        choiceBoxSizeTime.getItems().addAll(sizeTimeData);
        choiceBoxPosition.setValue("Stanowisko");
        choiceBoxPosition.getItems().addAll(positionData);
        choiceBoxSizeTime.setOnAction(this::checkValues);
        choiceBoxPosition.setOnAction(this::checkValues);
        logger.info("Okno Dodaj pracownika zostało otwarte.");
    }

    @FXML
    void buttonDodajClicked(MouseEvent event) {
        name = textFieldName.getText();
        surname = textFieldSecendName.getText();
        setSizeTime(choiceBoxSizeTime.getValue());
        position = choiceBoxPosition.getValue();

        employeeModel.addEmployeeToDatabase(name,surname,sizeTime,position);
        ShowEmployeeController.getStageAddEmployee().close();

        logger.info("Dodano pracownika. Okno Dodaj pracownika zostało zamknięte");
    }

    @FXML
    void buttonAnulujClicked(MouseEvent event) {
        logger.info("Okno Dodaj pracownika zostało zamknięte.");
        Stage stage = ShowEmployeeController.getStageAddEmployee();
        stage.close();
    }


}
