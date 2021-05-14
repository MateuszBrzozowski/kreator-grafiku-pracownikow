package pl.mbrzozowski.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbrzozowski.modelFx.ScheduleEmployeeGeneratorModel;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ChooseOpenTime {

    //TODO przekazać informację do Modelu jakie dni jakie godziny -poniedzialek -8-16 itd.

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private ScheduleEmployeeGeneratorModel scheduleEmployeeGeneratorModel;
    private String[] hour = new String[24];
    private String[] minute = new String[60];

    @FXML
    private ComboBox<String> comboBoxMainHour;
    @FXML
    private ComboBox<String> comboBoxMainMinute;
    @FXML
    private ComboBox<String> comboBoxMainHourTo;
    @FXML
    private ComboBox<String> comboBoxMainMinuteTo;
    @FXML
    private ComboBox<String> comboBoxMondayHour;
    @FXML
    private ComboBox<String> comboBoxMondayMinute;
    @FXML
    private ComboBox<String> comboBoxMondayHourTo;
    @FXML
    private ComboBox<String> comboBoxMondayMinuteTo;
    @FXML
    private ComboBox<String> comboBoxTuesdayHour;
    @FXML
    private ComboBox<String> comboBoxTuesdayMinute;
    @FXML
    private ComboBox<String> comboBoxTuesdayHourTo;
    @FXML
    private ComboBox<String> comboBoxTuesdayMinuteTo;
    @FXML
    private ComboBox<String> comboBoxWednesdayHour;
    @FXML
    private ComboBox<String> comboBoxWednesdayMinute;
    @FXML
    private ComboBox<String> comboBoxWednesdayHourTo;
    @FXML
    private ComboBox<String> comboBoxWednesdayMinuteTo;
    @FXML
    private ComboBox<String> comboBoxThursdayHour;
    @FXML
    private ComboBox<String> comboBoxThursdayMinute;
    @FXML
    private ComboBox<String> comboBoxThursdayHourTo;
    @FXML
    private ComboBox<String> comboBoxThursdayMinuteTo;
    @FXML
    private ComboBox<String> comboBoxFridayHour;
    @FXML
    private ComboBox<String> comboBoxFridayMinute;
    @FXML
    private ComboBox<String> comboBoxFridayHourTo;
    @FXML
    private ComboBox<String> comboBoxFridayMinuteTo;
    @FXML
    private ComboBox<String> comboBoxSaturdayHour;
    @FXML
    private ComboBox<String> comboBoxSaturdayMinute;
    @FXML
    private ComboBox<String> comboBoxSaturdayHourTo;
    @FXML
    private ComboBox<String> comboBoxSaturdayMinuteTo;
    @FXML
    private ComboBox<String> comboBoxSundayHour;
    @FXML
    private ComboBox<String> comboBoxSundayMinute;
    @FXML
    private ComboBox<String> comboBoxSundayHourTo;
    @FXML
    private ComboBox<String> comboBoxSundayMinuteTo;


    @FXML
    public void initialize(){
        scheduleEmployeeGeneratorModel = ScheduleEmployeeGeneratorController.getScheduleEmployeeGeneratorModel();
        fillTableHourAndMinute();
        fillComboBoxes();

    }

    private void fillComboBoxes() {
        List<ComboBox> comboBoxesHour = new LinkedList<>();
        comboBoxesHour.add(comboBoxMainHour);
        comboBoxesHour.add(comboBoxMainHourTo);
        comboBoxesHour.add(comboBoxMondayHour);
        comboBoxesHour.add(comboBoxMondayHourTo);
        comboBoxesHour.add(comboBoxTuesdayHour);
        comboBoxesHour.add(comboBoxTuesdayHourTo);
        comboBoxesHour.add(comboBoxWednesdayHour);
        comboBoxesHour.add(comboBoxWednesdayHourTo);
        comboBoxesHour.add(comboBoxThursdayHour);
        comboBoxesHour.add(comboBoxThursdayHourTo);
        comboBoxesHour.add(comboBoxFridayHour);
        comboBoxesHour.add(comboBoxFridayHourTo);
        comboBoxesHour.add(comboBoxSaturdayHour);
        comboBoxesHour.add(comboBoxSaturdayHourTo);
        comboBoxesHour.add(comboBoxSundayHour);
        comboBoxesHour.add(comboBoxSundayHourTo);

        List<ComboBox> comboBoxesMinute = new LinkedList<>();
        comboBoxesMinute.add(comboBoxMainMinute);
        comboBoxesMinute.add(comboBoxMainMinuteTo);
        comboBoxesMinute.add(comboBoxMondayMinute);
        comboBoxesMinute.add(comboBoxMondayMinuteTo);
        comboBoxesMinute.add(comboBoxTuesdayMinute);
        comboBoxesMinute.add(comboBoxTuesdayMinuteTo);
        comboBoxesMinute.add(comboBoxWednesdayMinute);
        comboBoxesMinute.add(comboBoxWednesdayMinuteTo);
        comboBoxesMinute.add(comboBoxThursdayMinute);
        comboBoxesMinute.add(comboBoxThursdayMinuteTo);
        comboBoxesMinute.add(comboBoxFridayMinute);
        comboBoxesMinute.add(comboBoxFridayMinuteTo);
        comboBoxesMinute.add(comboBoxSaturdayMinute);
        comboBoxesMinute.add(comboBoxSaturdayMinuteTo);
        comboBoxesMinute.add(comboBoxSundayMinute);
        comboBoxesMinute.add(comboBoxSundayMinuteTo);

        for (int i = 0; i < comboBoxesHour.size(); i++) {
            comboBoxesHour.get(i).getItems().addAll(hour);
            comboBoxesHour.get(i).setValue("08");
        }

        for (int i = 0; i < comboBoxesMinute.size(); i++) {
            comboBoxesMinute.get(i).getItems().addAll(minute);
            comboBoxesMinute.get(i).setValue("00");
        }

    }

    private void fillTableHourAndMinute() {
        for (int i = 0; i < hour.length; i++) {
            String buff;
            if (i<10){
                 buff = "0"+i;
            }else {
                buff = String.valueOf(i);
            }
            hour[i]=buff;
        }
        for (int i = 0; i < minute.length; i++) {
            String buff;
            if (i<10){
                buff = "0"+i;
            }else {
                buff = String.valueOf(i);
            }
            minute[i]=buff;
        }
    }

    @FXML
    public void comboBoxMainHour_OnAction(ActionEvent actionEvent) {
        String value = comboBoxMainHour.getValue();

        comboBoxMondayHour.setValue(value);
        comboBoxTuesdayHour.setValue(value);
        comboBoxWednesdayHour.setValue(value);
        comboBoxThursdayHour.setValue(value);
        comboBoxFridayHour.setValue(value);
        comboBoxSaturdayHour.setValue(value);
        comboBoxSundayHour.setValue(value);
    }

    @FXML
    public void comboBoxMainHourTo_OnAction(ActionEvent actionEvent) {
        String value = comboBoxMainHourTo.getValue();

        comboBoxMondayHourTo.setValue(value);
        comboBoxTuesdayHourTo.setValue(value);
        comboBoxWednesdayHourTo.setValue(value);
        comboBoxThursdayHourTo.setValue(value);
        comboBoxFridayHourTo.setValue(value);
        comboBoxSaturdayHourTo.setValue(value);
        comboBoxSundayHourTo.setValue(value);

    }

    @FXML
    public void comboBoxMainMinute_OnAction(ActionEvent actionEvent) {
        String value = comboBoxMainMinute.getValue();

        comboBoxMondayMinute.setValue(value);
        comboBoxTuesdayMinute.setValue(value);
        comboBoxWednesdayMinute.setValue(value);
        comboBoxThursdayMinute.setValue(value);
        comboBoxFridayMinute.setValue(value);
        comboBoxSaturdayMinute.setValue(value);
        comboBoxSundayMinute.setValue(value);
    }

    @FXML
    public void comboBoxMainMinuteTo_OnAction(ActionEvent actionEvent) {
        String value = comboBoxMainMinuteTo.getValue();

        comboBoxMondayMinuteTo.setValue(value);
        comboBoxTuesdayMinuteTo.setValue(value);
        comboBoxWednesdayMinuteTo.setValue(value);
        comboBoxThursdayMinuteTo.setValue(value);
        comboBoxFridayMinuteTo.setValue(value);
        comboBoxSaturdayMinuteTo.setValue(value);
        comboBoxSundayMinuteTo.setValue(value);
    }
}
