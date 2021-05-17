package pl.mbrzozowski.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbrzozowski.modelFx.ScheduleEmployeeGeneratorModel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ChooseWorkingDayController {

    //TODO Zaimplementowanie funkcjonalności buttonów - klik - zmiana na odwrotny i napisanie logiki dla danego dnia
    //TODO Tablica ktory dzien jest pracujacy w Modelu

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private ScheduleEmployeeGeneratorModel scheduleEmployeeGeneratorModel;

    @FXML
    private Button dayOfMonth_01;
    @FXML
    private Button dayOfMonth_02;
    @FXML
    private Button dayOfMonth_03;
    @FXML
    private Button dayOfMonth_04;
    @FXML
    private Button dayOfMonth_05;
    @FXML
    private Button dayOfMonth_06;
    @FXML
    private Button dayOfMonth_08;
    @FXML
    private Button dayOfMonth_09;
    @FXML
    private Button dayOfMonth_10;
    @FXML
    private Button dayOfMonth_11;
    @FXML
    private Button dayOfMonth_12;
    @FXML
    private Button dayOfMonth_13;
    @FXML
    private Button dayOfMonth_14;
    @FXML
    private Button dayOfMonth_07;
    @FXML
    private Button dayOfMonth_15;
    @FXML
    private Button dayOfMonth_16;
    @FXML
    private Button dayOfMonth_17;
    @FXML
    private Button dayOfMonth_18;
    @FXML
    private Button dayOfMonth_19;
    @FXML
    private Button dayOfMonth_20;
    @FXML
    private Button dayOfMonth_21;
    @FXML
    private Button dayOfMonth_22;
    @FXML
    private Button dayOfMonth_23;
    @FXML
    private Button dayOfMonth_24;
    @FXML
    private Button dayOfMonth_25;
    @FXML
    private Button dayOfMonth_26;
    @FXML
    private Button dayOfMonth_27;
    @FXML
    private Button dayOfMonth_28;
    @FXML
    private Button dayOfMonth_29;
    @FXML
    private Button dayOfMonth_30;
    @FXML
    private Button dayOfMonth_31;
    @FXML
    private Button dayOfMonth_32;
    @FXML
    private Button dayOfMonth_33;
    @FXML
    private Button dayOfMonth_34;
    @FXML
    private Button dayOfMonth_35;
    @FXML
    private Button dayOfMonth_36;
    @FXML
    private Button dayOfMonth_37;
    @FXML
    private Button dayOfMonth_38;
    @FXML
    private Button dayOfMonth_39;
    @FXML
    private Button dayOfMonth_40;
    @FXML
    private Button dayOfMonth_41;
    @FXML
    private Button dayOfMonth_42;
    private List<Button> buttonDays = new LinkedList<>();
    private Boolean[] buttonIsActiveInMonth = new Boolean[42];

    //TODO Funkcjonalność klikania w dzień - zmiana na pracujacy i nie pracujacy - zmiana kolorów.

    @FXML
    public void initialize(){
        scheduleEmployeeGeneratorModel = ScheduleEmployeeGeneratorController.getScheduleEmployeeGeneratorModel();
        initButtonDaysLists();
        initButtonDaysIsActive();
        initMonth();
    }

    private void initButtonDaysIsActive() {
        for (int i = 0; i < buttonIsActiveInMonth.length; i++) {
            buttonIsActiveInMonth[i]=false;
        }
    }

    private void initButtonDaysLists() {
        buttonDays.add(dayOfMonth_01);
        buttonDays.add(dayOfMonth_02);
        buttonDays.add(dayOfMonth_03);
        buttonDays.add(dayOfMonth_04);
        buttonDays.add(dayOfMonth_05);
        buttonDays.add(dayOfMonth_06);
        buttonDays.add(dayOfMonth_07);
        buttonDays.add(dayOfMonth_08);
        buttonDays.add(dayOfMonth_09);
        buttonDays.add(dayOfMonth_10);
        buttonDays.add(dayOfMonth_11);
        buttonDays.add(dayOfMonth_12);
        buttonDays.add(dayOfMonth_13);
        buttonDays.add(dayOfMonth_14);
        buttonDays.add(dayOfMonth_15);
        buttonDays.add(dayOfMonth_16);
        buttonDays.add(dayOfMonth_17);
        buttonDays.add(dayOfMonth_18);
        buttonDays.add(dayOfMonth_19);
        buttonDays.add(dayOfMonth_20);
        buttonDays.add(dayOfMonth_21);
        buttonDays.add(dayOfMonth_22);
        buttonDays.add(dayOfMonth_23);
        buttonDays.add(dayOfMonth_24);
        buttonDays.add(dayOfMonth_25);
        buttonDays.add(dayOfMonth_26);
        buttonDays.add(dayOfMonth_27);
        buttonDays.add(dayOfMonth_28);
        buttonDays.add(dayOfMonth_29);
        buttonDays.add(dayOfMonth_30);
        buttonDays.add(dayOfMonth_31);
        buttonDays.add(dayOfMonth_32);
        buttonDays.add(dayOfMonth_33);
        buttonDays.add(dayOfMonth_34);
        buttonDays.add(dayOfMonth_35);
        buttonDays.add(dayOfMonth_36);
        buttonDays.add(dayOfMonth_37);
        buttonDays.add(dayOfMonth_38);
        buttonDays.add(dayOfMonth_39);
        buttonDays.add(dayOfMonth_40);
        buttonDays.add(dayOfMonth_41);
        buttonDays.add(dayOfMonth_42);
    }

    private void initMonth() {
        LocalDate date = LocalDate.of(scheduleEmployeeGeneratorModel.getYear(),scheduleEmployeeGeneratorModel.getMonth(),1);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int intDayOfMonth = dayOfWeek.getValue();
        int lengthOfMonth = date.lengthOfMonth();
        logger.info(String.valueOf(lengthOfMonth));

        for (int i = 0; i < lengthOfMonth; i++) {
            buttonDays.get(intDayOfMonth-1).setText(String.valueOf(i+1));
            buttonIsActiveInMonth[intDayOfMonth-1]=true;
            intDayOfMonth++;
        }

        for (int i = 0; i < buttonIsActiveInMonth.length; i++) {
            if (buttonIsActiveInMonth[i]==false){
                buttonDays.get(i).getStyleClass().clear();
                buttonDays.get(i).getStyleClass().add("buttonDay");
                buttonDays.get(i).getStyleClass().add("buttonNoActive");

            }else{
                buttonDays.get(i).getStyleClass().clear();
                buttonDays.get(i).getStyleClass().add("buttonDay");
                buttonDays.get(i).getStyleClass().add("buttonDayOpen");
            }

        }
    }


}
