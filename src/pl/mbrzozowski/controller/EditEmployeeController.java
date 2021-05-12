package pl.mbrzozowski.controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbrzozowski.modelFx.EmployeeFX;
import pl.mbrzozowski.modelFx.EmployeeModel;

public class EditEmployeeController extends EmployeeValues{

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private EmployeeModel employeeModel;
    private int id;

    @FXML
    public void initialize(){
        this.employeeModel = MainWindowController.getEmployeeModel();
        buttonDodaj.setDisable(true);
        EmployeeFX employeeFX = employeeModel.getEmployeeSelected();
        id = employeeFX.getId();
        name = employeeFX.getName();
        surname = employeeFX.getSurname();
        sizeTime = employeeFX.getSizeTime();
        position = employeeFX.getPosition();

        textFieldName.setText(name);
        textFieldSurname.setText(surname);
        choiceBoxSizeTime.getItems().addAll(sizeTimeData);
        choiceBoxPosition.getItems().addAll(positionData);
        choiceBoxPosition.setValue(position);
        choiceBoxSizeTime.setValue(setValueForSizeTime(sizeTime));

        choiceBoxSizeTime.setOnAction(this::checkValues);
        choiceBoxPosition.setOnAction(this::checkValues);
        logger.info("Okno Edytuj pracownika zostało otwarte.");
    }

    public String setValueForSizeTime(int sizeTime){
        switch (sizeTime){
            case 1:
                return "Pełny etat";
            case 2:
                return "1/2 etatu";
            case 3:
                return "1/3 etatu";
            case 4:
                return "1/4 etatu";
            default:
                return "Pełny etat";
        }
    }

    @FXML
    public void buttonDodajClicked(MouseEvent event) {
        name = textFieldName.getText();
        surname = textFieldSurname.getText();
        setSizeTime(choiceBoxSizeTime.getValue());
        position = choiceBoxPosition.getValue();

        employeeModel.updateEmployeDataBase(id,name,surname,sizeTime,position);
        ShowEmployeeController.getStageEditEmployee().close();
        employeeModel.init();

        logger.info("Zedytowano pracownika. Okno Edytuj pracownika zostało zamknięte");
    }

    @FXML
    void buttonAnulujClicked(MouseEvent event) {
        logger.info("Okno Edytuj pracownika zostało zamknięte.");
        Stage stage = ShowEmployeeController.getStageEditEmployee();
        stage.close();
    }

}
