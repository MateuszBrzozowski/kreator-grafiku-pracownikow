package pl.mbrzozowski.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DayOfMonthMy {

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private DayOfWeek dayOfWeek;
    private boolean isWorkingDay;
    private LocalTime timeFrom;
    private LocalTime timeTo;

    public DayOfMonthMy(DayOfWeek dayOfWeek, boolean isWorkingDay, LocalTime timeFrom, LocalTime timeTo) {
        this.dayOfWeek = dayOfWeek;
        this.isWorkingDay = isWorkingDay;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setWorkingDay(boolean workingDay) {
        isWorkingDay = workingDay;
    }

    public void setTimeFrom(LocalTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public void setTimeTo(LocalTime timeTo) {
        this.timeTo = timeTo;
    }

    public void showDay(){
        logger.info("{} - Pracujący?: {}; od - {} - do {}",dayOfWeek,isWorkingDay,timeFrom,timeTo);
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public boolean isWorkingDay() {
        return isWorkingDay;
    }
}
