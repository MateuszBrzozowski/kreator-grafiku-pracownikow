package pl.mbrzozowski.windows;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class addEmployeeController {

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private static int id;
    private static String name;
    private static String secondName;
    private static int sizeTime;
    private static String position;

    @FXML
    private TextField textFieldId;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldSecendName;

    @FXML
    private ChoiceBox choiceBoxSizeTime;

    @FXML
    private ChoiceBox choiceBoxPosition;

    @FXML
    private Button buttonDodaj;

    @FXML
    private Button buttonAnuluj;

    @FXML
    void buttonAnulujClicked(MouseEvent event) {
        MainWindowController.stageAddEmployee.close();

    }

    @FXML
    void buttonDodajClicked(MouseEvent event) {
        boolean[] acceptData = new boolean[6];
        acceptData[0] = validationId(textFieldId.getText());
        acceptData[1] = validationString(textFieldName,textFieldName.getText());
        acceptData[2] = validationString(textFieldSecendName,textFieldSecendName.getText());
        acceptData[3] = validationSizeTime(choiceBoxSizeTime.getValue().toString());
        acceptData[4] = validationPosition(choiceBoxPosition.getValue().toString());
        acceptData[5] = true;
        for (int i = 0; i < 5; i++) {
            if (acceptData[i]==false){
                acceptData[5]=false;
                break;
            }
        }

        //TODO Sprawdzić czy dodawany pracownik już nie istnieje o takim samym ID

        if (acceptData[5]){
            MainWindowController.shop.addEmployee(id,name,secondName,sizeTime,position);
            MainWindowController.stageAddEmployee.close();
        }

    }

    public boolean validationSizeTime(String value) {
        if (value.equals("Wysokość etatu")){
            logger.error("Nie wybrano wielkości etatu.");
            return false;
        }

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

        return true;
    }

    public boolean validationPosition(String value) {
        if(value.equals("Stanowisko")){
            logger.error("Nie wybrano stanowiska.");
            return false;
        }

        position = value;
        return true;
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

    public boolean validationId(String textFieldId) {
        try {
            id = Integer.parseInt(textFieldId);
            return true;
        }catch (NumberFormatException e){
            logger.error("Podane ID nie jest liczbą!");
            return false;
        }

    }

    public void initialize(){
        logger.info("Okno Dodaj pracownika zostało otwarte.");
        choiceBoxSizeTime.setValue("Wysokość etatu");
        choiceBoxSizeTime.getItems().add("Pełny etat");
        choiceBoxSizeTime.getItems().add("1/2 etatu");
        choiceBoxSizeTime.getItems().add("1/3 etatu");
        choiceBoxSizeTime.getItems().add("1/4 etatu");

        choiceBoxPosition.setValue("Stanowisko");
        choiceBoxPosition.getItems().add("Dyrektor");
        choiceBoxPosition.getItems().add("Manager");
        choiceBoxPosition.getItems().add("Sprzedawca");

        buttonDodaj.setDefaultButton(true);

    }

}
