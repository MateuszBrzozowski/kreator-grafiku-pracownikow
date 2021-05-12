package pl.mbrzozowski.controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbrzozowski.modelFx.EmployeeModel;

public class EditEmployeeController extends EmployeeValues{

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private EmployeeModel employeeModel;

    @FXML
    public void initialize(){
        this.employeeModel = MainWindowController.getEmployeeModel();
    }

    @FXML
    public void buttonDodajClicked(MouseEvent event) {

    }

    @FXML
    public void buttonAnulujClicked(MouseEvent event) {

    }
}
