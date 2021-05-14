package pl.mbrzozowski.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbrzozowski.helpers.Converter;
import pl.mbrzozowski.modelFx.ScheduleEmployeeGeneratorModel;

import java.time.LocalDateTime;

public class ChooseMonthController {

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private ScheduleEmployeeGeneratorModel scheduleEmployeeGeneratorModel;
    int month;
    int year;
    private String[] monthName = {
            "Styczeń",
            "Luty",
            "Marzec",
            "Kwiecień",
            "Maj",
            "Czerwiec",
            "Lipiec",
            "Sierpień",
            "Wrzesień",
            "Październik",
            "Listopad",
            "Grudzień"
    };
    private Integer[] yearName = new Integer[10];

    @FXML
    private ComboBox<String> comboBoxMonth;
    @FXML
    private ComboBox<Integer> comboBoxYear;

    @FXML
    public void initialize(){
        scheduleEmployeeGeneratorModel = ScheduleEmployeeGeneratorController.getScheduleEmployeeGeneratorModel();

        LocalDateTime date = LocalDateTime.now();
        month = date.getMonthValue();
        year = date.getYear();
        comboBoxMonth.getItems().addAll(monthName);
        putToTablePlusTenYears(year);
        comboBoxYear.getItems().addAll(yearName);

    }

    private void putToTablePlusTenYears(int year) {
        for (int i=0 ; i<10 ; i++){
            yearName[i] = year;
            year++;
        }
    }

    public void comboBoxCheck_onAction(ActionEvent actionEvent) {


        if (comboBoxMonth.getValue()!=null && comboBoxYear.getValue()!=null){
            Converter converter = new Converter();
            int monthInt = converter.stringToInt(comboBoxMonth.getValue());

            if (comboBoxYear.getValue()==year && monthInt>=month){
                scheduleEmployeeGeneratorModel.setIsNotDisableButtonNext(true);
            }else if (comboBoxYear.getValue()>year){
                scheduleEmployeeGeneratorModel.setIsNotDisableButtonNext(true);
            } else {
                scheduleEmployeeGeneratorModel.setIsNotDisableButtonNext(false);
            }
        }else {
            scheduleEmployeeGeneratorModel.setIsNotDisableButtonNext(false);
        }
    }
}
