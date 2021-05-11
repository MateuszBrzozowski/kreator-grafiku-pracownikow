package pl.mbrzozowski.controller;

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
import pl.mbrzozowski.database.DBConnector;

public class AddEmployeeController {

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private static String name;
    private static String secondName;
    private static int sizeTime;
    private static String position;
    private ShowEmployeeController showEmployeeController;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldSecendName;

    @FXML
    private ChoiceBox<String> choiceBoxSizeTime;

    private String[] sizeTimeData = {"Pełny etat","1/2 etatu","1/3 etatu","1/4 etatu"};

    @FXML
    private ChoiceBox<String> choiceBoxPosition;

    private String[] positionData = {"Dyrektor","Manager","Sprzedawca"};

    @FXML
    private Button buttonDodaj;

    @FXML
    private Button buttonAnuluj;

    public void initialize(){
        name=null;
        secondName=null;
        position = null;
        sizeTime=0;
        choiceBoxSizeTime.setValue("Wysokość etatu");
        choiceBoxSizeTime.getItems().addAll(sizeTimeData);
        choiceBoxPosition.setValue("Stanowisko");
        choiceBoxPosition.getItems().addAll(positionData);
        buttonDodaj.setDisable(true);
        choiceBoxSizeTime.setOnAction(this::checkValues);
        choiceBoxPosition.setOnAction(this::checkValues);
        logger.info("Okno Dodaj pracownika zostało otwarte.");
    }

    @FXML
    void buttonAnulujClicked(MouseEvent event) {
        logger.info("Okno Dodaj pracownika zostało zamknięte.");
        Stage stage = ShowEmployeeController.getStageAddEmployee();
        stage.close();
    }

    @FXML
    void buttonDodajClicked(MouseEvent event) {
        name = textFieldName.getText();
        secondName = textFieldSecendName.getText();
        setSizeTime(choiceBoxSizeTime.getValue());
        position = choiceBoxPosition.getValue();

        DBConnector connector = new DBConnector();
        String queryInsert="INSERT INTO `employee`(`name`, `surname`, `sizeTime`, `position`) VALUES ('%s','%s','%d','%s')";
        logger.info(String.format(queryInsert,name,secondName,sizeTime,position));
        connector.executeQuery(String.format(queryInsert,name,secondName,sizeTime,position));
        MainWindowController.getShop().clearEmployees();
        MainWindowController.getAllEmployeFromDatabase();

        ShowEmployeeController.getStageAddEmployee().close();

//        ShowEmployeeController showEmployeeController = new ShowEmployeeController();
//        showEmployeeController.updateTableView();
        logger.info("Dodano pracownika. Okno Dodaj pracownika zostało zamknięte");
    }

    void checkValues(ActionEvent actionEvent){
        if(!getIfName() || !getIfSurname() || !getIfSizeTime() || !getIfPosition()){
            buttonDodaj.setDisable(true);
        }else {
            if (validationString(textFieldName,textFieldName.getText()) && validationString(textFieldSecendName,textFieldSecendName.getText())){
                buttonDodaj.setDisable(false);
            }
            else {
                buttonDodaj.setDisable(true);
            }
        }
    }

    @FXML
    public void checkValuesAfterKeyEvent(KeyEvent keyEvent){
        checkValues(new ActionEvent());
    }

    public boolean getIfSizeTime() {
        if (choiceBoxSizeTime.getValue().equals("Wysokość etatu")) {
            return false;
        }
        return true;
    }

    public boolean getIfPosition() {
        if (choiceBoxPosition.getValue().equals("Stanowisko")) {
            return false;
        }
        return true;
    }

    public boolean getIfName(){
        if (textFieldName.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean getIfSurname(){
        if (textFieldSecendName.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    public void setSizeTime(String value) {
        switch (value){
            case "Pełny etat":
                sizeTime = 1;
                break;
            case "1/2 etatu":
                sizeTime = 2;
                break;
            case "1/3 etatu":
                sizeTime = 3;
                break;
            case "1/4 etatu":
                sizeTime = 4;
                break;
            default:
                sizeTime = 1;
        }
    }


    public boolean validationString(TextField textField, String text) {
        if (text.length()>0){
            for (int i = 0; i < text.length(); i++) {
                char buffer = text.charAt(i);
                if (!Character.isLetter(buffer)){
                    logger.error("[{}] - Błedne dane wyjściowe. Znaki niedopuszczalne.",textField.getPromptText());
                    return false;
                }
            }
        }else if (text.length()==0){
            logger.error("[{}] - Nie wprowadzono danych",textField.getPromptText());
        }

        String whichData = textField.getPromptText();
        switch (whichData){
            case "imię":
                name = textField.getText();
                break;
            case "nazwisko":
                secondName = textField.getText();
                break;
        }

        return true;
    }

}
