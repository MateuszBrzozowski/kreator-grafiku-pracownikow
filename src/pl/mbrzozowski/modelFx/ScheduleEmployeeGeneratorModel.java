package pl.mbrzozowski.modelFx;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Button;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbrzozowski.controller.MainWindowController;
import pl.mbrzozowski.controller.ScheduleEmployeeGeneratorController;
import pl.mbrzozowski.shop.DayOfMonthMy;
import pl.mbrzozowski.shop.DayOfWeekMy;

import java.time.DayOfWeek;
import java.time.LocalTime;


public class ScheduleEmployeeGeneratorModel {

    //TODO Stworzyc grafik dla każdego pracownika
    //TODO ile godzin w danym miesiacu ma przepracowac pracownik - pelny etat

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private ScheduleEmployeeGeneratorController scheduleEmployeeGeneratorController;
    private BooleanProperty isDisableButtonNext = new SimpleBooleanProperty();
    private EmployeeModel employeeModel;
    private DayOfWeekMy[] dayOfWeekMy = new DayOfWeekMy[7]; // Standardowe godziny otwarcia  - 0 -poniedzialek, 1 - wtorek -2 sroda ... 6- niedziela
    private int howManyDays;
    private int startDay; //Ktorym dniem tygodnia rozpoczyna sie miesiac ktory kreujemy - 1 - poniedzialek; 7 - niedziela
    private DayOfMonthMy[] daysOfMonth;

    private Integer month;
    private Integer year;


    public ScheduleEmployeeGeneratorModel(Button button, ScheduleEmployeeGeneratorController controller) {
        scheduleEmployeeGeneratorController = controller;
        isDisableButtonNext.set(false);
        scheduleEmployeeGeneratorController.buttonNext.disableProperty().bind(isDisableButtonNext.not());
        this.employeeModel = MainWindowController.getEmployeeModel();
    }

    public boolean getIsDisableButtonNext() {
        return isDisableButtonNext.get();
    }

    public BooleanProperty isDisableButtonNextProperty() {
        return isDisableButtonNext;
    }

    public void setIsNotDisableButtonNext(boolean isDisableButtonNext) {
        this.isDisableButtonNext.set(isDisableButtonNext);
    }

    public void setMonth(Integer value) {
        this.month = value;
    }

    public void setYear(Integer value) {
        this.year = value;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    public void setDayOfWeekMy(int index, DayOfWeekMy day){
        this.dayOfWeekMy[index] = day;
    }

    public void setHowManyDays(int howManyDays) {
        this.howManyDays = howManyDays;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public void initMonth(){
        daysOfMonth = new DayOfMonthMy[howManyDays];
        LocalTime timeFrom;
        LocalTime timeTo;
        DayOfWeek dayOfWeek;
        int j = startDay-1;
        for (int i = 0; i < daysOfMonth.length; i++) {
            timeFrom = dayOfWeekMy[j].getTimeFrom();
            timeTo = dayOfWeekMy[j].getTimeTo();
            dayOfWeek = whichDay(j);
            j++;
            if(j>6){
                j=0;
            }
            DayOfMonthMy day = new DayOfMonthMy(dayOfWeek,false,timeFrom,timeTo);
            daysOfMonth[i] = day;
        }
    }

    private DayOfWeek whichDay(int j) {
        switch (j){
            case 0 -> {
                return DayOfWeek.MONDAY;
            }
            case 1 -> {
                return DayOfWeek.TUESDAY;
            }
            case 2 -> {
                return DayOfWeek.WEDNESDAY;
            }
            case 3 -> {
                return DayOfWeek.THURSDAY;
            }
            case 4 -> {
                return DayOfWeek.FRIDAY;
            }
            case 5 -> {
                return DayOfWeek.SATURDAY;
            }
            case 6 -> {
                return DayOfWeek.SUNDAY;
            }
            default -> {
                return null;
            }
        }
    }

    public void setDayOfMonth(int index, boolean isWorkingDay){
        daysOfMonth[index].setWorkingDay(isWorkingDay);
    }

    public void createSchedule(){
        int fullTime = fullTimeHowManyHour();

    }

    private int fullTimeHowManyHour() {
        int sum=0;
        for (int i = 0; i < daysOfMonth.length; i++) {
            DayOfWeek d = daysOfMonth[i].getDayOfWeek();
            if (d.getValue()!=6 && d.getValue()!=7){
                if (daysOfMonth[i].isWorkingDay()){
                    sum+=8;
                }
            }
        }
        logger.info(String.valueOf(sum));
        return sum;
    }
}
