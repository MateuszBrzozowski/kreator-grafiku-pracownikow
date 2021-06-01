package pl.mbrzozowski.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;

public class DayOfWeekMy {

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private LocalTime timeFrom;
    private LocalTime timeTo;

    public DayOfWeekMy() {
    }

    public DayOfWeekMy(LocalTime localTimeFrom, LocalTime localTimeTo) {
        this.timeFrom = localTimeFrom;
        this.timeTo = localTimeTo;
    }

    public LocalTime getTimeFrom() {
        return timeFrom;
    }

    public LocalTime getTimeTo() {
        return timeTo;
    }
}
