package pl.mbrzozowski.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbrzozowski.modelFx.EmployeeModel;

public abstract class EmployeeValues {

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    protected static String name =null;
    protected static String surname =null;
    protected static int sizeTime=0;
    protected static String position=null;

    @FXML
    protected TextField textFieldName;
    @FXML
    protected TextField textFieldSurname;
    @FXML
    protected ChoiceBox<String> choiceBoxSizeTime;
    protected String[] sizeTimeData = {"Pełny etat","1/2 etatu","1/3 etatu","1/4 etatu"};
    @FXML
    protected ChoiceBox<String> choiceBoxPosition;
    protected String[] positionData = {"Dyrektor","Manager","Sprzedawca"};
    @FXML
    protected Button buttonDodaj;


    public void checkValues(ActionEvent actionEvent){
        if(!getIfName() || !getIfSurname() || !getIfSizeTime() || !getIfPosition()){
            buttonDodaj.setDisable(true);
        }else {
            if (validationString(textFieldName,textFieldName.getText()) && validationString(textFieldSurname, textFieldSurname.getText())){
                buttonDodaj.setDisable(false);
            }
            else {
                buttonDodaj.setDisable(true);
            }
        }
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
        if (textFieldSurname.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * @param textField
     * @param text w textField
     * @return true - jeżli text jest dopuszczalny do wprowadzniea; false - jeżeli tekst zawiera znaki nie prawidłowe.
     */
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
                surname = textField.getText();
                break;
        }

        return true;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        EmployeeValues.name = name;
    }

    public static String getSurname() {
        return surname;
    }

    public static void setSurname(String surname) {
        EmployeeValues.surname = surname;
    }

    public static int getSizeTime() {
        return sizeTime;
    }

    public static void setSizeTime(int sizeTime) {
        EmployeeValues.sizeTime = sizeTime;
    }

    public static String getPosition() {
        return position;
    }

    public static void setPosition(String position) {
        EmployeeValues.position = position;
    }
}
