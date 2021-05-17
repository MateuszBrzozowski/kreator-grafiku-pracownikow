package pl.mbrzozowski.modelFx;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbrzozowski.controller.ScheduleEmployeeGeneratorController;


public class ScheduleEmployeeGeneratorModel {

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private ScheduleEmployeeGeneratorController scheduleEmployeeGeneratorController;
    private BooleanProperty isDisableButtonNext = new SimpleBooleanProperty();

    private Integer month;
    private Integer year;

    public ScheduleEmployeeGeneratorModel(Button button, ScheduleEmployeeGeneratorController controller) {
        scheduleEmployeeGeneratorController = controller;
        isDisableButtonNext.set(false);
        scheduleEmployeeGeneratorController.buttonNext.disableProperty().bind(isDisableButtonNext.not());
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
}
