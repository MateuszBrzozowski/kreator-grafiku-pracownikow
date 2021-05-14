package pl.mbrzozowski.controller;

import javafx.fxml.FXML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbrzozowski.modelFx.ScheduleEmployeeGeneratorModel;

public class ChooseWorkingDayController {

    //TODO Zaimplementowania miesiąca który został wcześniej wybrany
    //TODO Wypisanie dni w buttonach w odpowiednich miejscach
    //TODO Wyłączenie dni które są z poza misiąca
    //TODO Zaimplementowanie funkcjonalności buttonów - klik - zmiana na odwrotny i napisanie logiki dla danego dnia
    //TODO Tablica ktory dzien jest pracujacy w Modelu

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private ScheduleEmployeeGeneratorModel scheduleEmployeeGeneratorModel;

    @FXML
    public void initialize(){
        scheduleEmployeeGeneratorModel = ScheduleEmployeeGeneratorController.getScheduleEmployeeGeneratorModel();

    }



}
