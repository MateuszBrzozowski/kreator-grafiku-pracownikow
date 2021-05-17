package pl.mbrzozowski.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbrzozowski.modelFx.ScheduleEmployeeGeneratorModel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ChooseWorkingDayController {

    //TODO przekazac do modelu ktory dzien miesia jest otwarty.

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
    private Boolean[] isWorkingDays;

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
        isWorkingDays = new Boolean[lengthOfMonth];
        logger.info(String.valueOf(lengthOfMonth));
        //Wypełnienie kalendarza
        for (int i = 0; i < lengthOfMonth; i++) {
            buttonDays.get(intDayOfMonth-1).setText(String.valueOf(i+1));
            buttonIsActiveInMonth[intDayOfMonth-1]=true;
            intDayOfMonth++;
        }
        //Jezeli imitacja dnia(button) jest w danym dniu to ustawiamy go na otwartego. Dni z po za miesiaca ustawiamy na nie aktywne.
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
        for (int i = 0; i < isWorkingDays.length; i++) {
            isWorkingDays[i]=true;
        }
        //Ustawienie wszystkich niedziel na zamkniete (taki mamy klimat)
        changeThisDay(dayOfMonth_07,7);
        changeThisDay(dayOfMonth_14,14);
        changeThisDay(dayOfMonth_21,21);
        changeThisDay(dayOfMonth_28,28);
        changeThisDay(dayOfMonth_35,35);
        changeThisDay(dayOfMonth_42,42);
    }

    public void thisDayIsClose(Button button){
        button.getStyleClass().clear();
        button.getStyleClass().add("buttonDay");
        button.getStyleClass().add("buttonDayClose");
    }

    public void thisDayIsOpen(Button button){
        button.getStyleClass().clear();
        button.getStyleClass().add("buttonDay");
        button.getStyleClass().add("buttonDayOpen");
    }

    public void changeThisDay(Button button, int i){
        if (buttonIsActiveInMonth[i-1]){
            int indexDayOfMonth = Integer.parseInt(button.getText())-1;
            if (isWorkingDays[indexDayOfMonth]){
                thisDayIsClose(button);
                isWorkingDays[indexDayOfMonth]=false;
            }else {
                thisDayIsOpen(button);
                isWorkingDays[indexDayOfMonth]=true;
            }
        }
    }

    @FXML
    public void dayOfMonth_01_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_01,1);
    }
    @FXML
    public void dayOfMonth_02_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_02,2);
    }
    @FXML
    public void dayOfMonth_03_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_03,3);
    }
    @FXML
    public void dayOfMonth_04_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_04,4);
    }
    @FXML
    public void dayOfMonth_05_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_05,5);
    }
    @FXML
    public void dayOfMonth_06_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_06,6);
    }
    @FXML
    public void dayOfMonth_07_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_07,7);
    }
    @FXML
    public void dayOfMonth_08_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_08,8);
    }
    @FXML
    public void dayOfMonth_09_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_09,9);
    }
    @FXML
    public void dayOfMonth_10_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_10,10);
    }
    @FXML
    public void dayOfMonth_11_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_11,11);
    }
    @FXML
    public void dayOfMonth_12_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_12,12);
    }
    @FXML
    public void dayOfMonth_13_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_13,13);
    }
    @FXML
    public void dayOfMonth_14_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_14,14);
    }
    @FXML
    public void dayOfMonth_15_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_15,15);
    }
    @FXML
    public void dayOfMonth_16_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_16,16);
    }
    @FXML
    public void dayOfMonth_17_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_17,17);
    }
    @FXML
    public void dayOfMonth_18_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_18,18);
    }
    @FXML
    public void dayOfMonth_19_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_19,19);
    }
    @FXML
    public void dayOfMonth_20_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_20,20);
    }
    @FXML
    public void dayOfMonth_21_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_21,21);
    }
    @FXML
    public void dayOfMonth_22_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_22,22);
    }
    @FXML
    public void dayOfMonth_23_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_23,23);
    }
    @FXML
    public void dayOfMonth_24_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_24,24);
    }
    @FXML
    public void dayOfMonth_25_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_25,25);
    }
    @FXML
    public void dayOfMonth_26_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_26,26);
    }
    @FXML
    public void dayOfMonth_27_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_27,27);
    }
    @FXML
    public void dayOfMonth_28_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_28,28);
    }
    @FXML
    public void dayOfMonth_29_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_29,29);
    }
    @FXML
    public void dayOfMonth_30_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_30,30);
    }
    @FXML
    public void dayOfMonth_31_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_31,31);
    }
    @FXML
    public void dayOfMonth_32_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_32,32);
    }
    @FXML
    public void dayOfMonth_33_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_33,33);
    }
    @FXML
    public void dayOfMonth_34_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_34,34);
    }
    @FXML
    public void dayOfMonth_35_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_35,35);
    }
    @FXML
    public void dayOfMonth_36_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_36,36);
    }
    @FXML
    public void dayOfMonth_37_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_37,37);
    }
    @FXML
    public void dayOfMonth_38_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_38,38);
    }
    @FXML
    public void dayOfMonth_39_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_39,39);
    }
    @FXML
    public void dayOfMonth_40_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_40,40);
    }
    @FXML
    public void dayOfMonth_41_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_41,41);
    }
    @FXML
    public void dayOfMonth_42_Clicked(MouseEvent event) {
        changeThisDay(dayOfMonth_42,42);
    }

    public void changeAllDayVertical(int j){
        for (int i = 0; i < 6; i++) {
            changeThisDay(buttonDays.get(j),j+1);
            j+=7;
        }
    }

    public void changeAllDayHorizontal(int j){
        for (int i = 1; i <= 7; i++) {
            changeThisDay(buttonDays.get(((j*7)+i)-1),((j*7)+i));
        }
    }

    @FXML
    public void allSunday_Clicked(MouseEvent event) {
        changeAllDayVertical(6);
    }
    @FXML
    public void allMonday_Clicked(MouseEvent event) {
        changeAllDayVertical(0);
    }
    @FXML
    public void allTuseday_Clicked(MouseEvent event) {
        changeAllDayVertical(1);
    }
    @FXML
    public void allWednsday_Clicked(MouseEvent event) {
        changeAllDayVertical(2);
    }
    @FXML
    public void allThursday_Clicked(MouseEvent event) {
        changeAllDayVertical(3);
    }
    @FXML
    public void allFriday_Clicked(MouseEvent event) {
        changeAllDayVertical(4);
    }
    @FXML
    public void allSaturday_Clicked(MouseEvent event) {
        changeAllDayVertical(5);
    }
    @FXML
    public void firstWeek_Clicked(MouseEvent event) {
        changeAllDayHorizontal(0);
    }
    @FXML
    public void secondWeek_Clicked(MouseEvent event) {
        changeAllDayHorizontal(1);
    }
    @FXML
    public void thirdWeek_Clicked(MouseEvent event) {
        changeAllDayHorizontal(2);
    }
    @FXML
    public void fourthWeek_Clicked(MouseEvent event) {
        changeAllDayHorizontal(3);
    }
    @FXML
    public void fifthWeek_Clicked(MouseEvent event) {
        changeAllDayHorizontal(4);
    }
    @FXML
    public void sixthWeek_Clicked(MouseEvent event) {
        changeAllDayHorizontal(5);
    }
}
