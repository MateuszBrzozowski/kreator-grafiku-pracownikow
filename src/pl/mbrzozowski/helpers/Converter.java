package pl.mbrzozowski.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Month;

public class Converter {

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());

    public int monthToInt(Month month){
        switch (month){
            case JANUARY -> {
                return 1;
            }
            case FEBRUARY -> {
                return 2;
            }
            case MARCH -> {
                return 3;
            }
            case APRIL -> {
                return 4;
            }
            case MAY -> {
                return 5;
            }
            case JUNE -> {
                return 6;
            }
            case JULY -> {
                return 7;
            }
            case AUGUST -> {
                return 8;
            }
            case SEPTEMBER -> {
                return 9;
            }
            case OCTOBER -> {
                return 10;
            }
            case NOVEMBER -> {
                return 11;
            }
            case DECEMBER -> {
                return 12;
            }
        }
        return 1;
    }

    public Month intToMonth(int month) {
        switch (month) {
            case 1 -> {
                return Month.JANUARY;
            }
            case 2 -> {
                return Month.FEBRUARY;
            }
            case 3 -> {
                return Month.MARCH;
            }
            case 4 -> {
                return Month.APRIL;
            }
            case 5 -> {
                return Month.MAY;
            }
            case 6 -> {
                return Month.JUNE;
            }
            case 7 -> {
                return Month.JULY;
            }
            case 8 -> {
                return Month.AUGUST;
            }
            case 9 -> {
                return Month.SEPTEMBER;
            }
            case 10 -> {
                return Month.OCTOBER;
            }
            case 11 -> {
                return Month.NOVEMBER;
            }
            case 12 -> {
                return Month.DECEMBER;
            }
        }
        return Month.JANUARY;
    }

    public Month stringToMonth(String month){
        month = month.toUpperCase();
        switch (month) {
            case "STYCZEŃ" -> {
                return Month.JANUARY;
            }
            case "LUTY" -> {
                return Month.FEBRUARY;
            }
            case "MARZEC" -> {
                return Month.MARCH;
            }
            case "KWIECIEŃ" -> {
                return Month.APRIL;
            }
            case "MAJ" -> {
                return Month.MAY;
            }
            case "CZERWIEC" -> {
                return Month.JUNE;
            }
            case "LIPIEC" -> {
                return Month.JULY;
            }
            case "SIERPIEŃ" -> {
                return Month.AUGUST;
            }
            case "WRZESIEŃ" -> {
                return Month.SEPTEMBER;
            }
            case "PAŹDZIERNIK" -> {
                return Month.OCTOBER;
            }
            case "LISTOPAD" -> {
                return Month.NOVEMBER;
            }
            case "GRUDZIEŃ" -> {
                return Month.DECEMBER;
            }
        }
        return Month.JANUARY;
    }

    public int stringToInt(String month){
        month = month.toUpperCase();
        switch (month) {
            case "STYCZEŃ" -> {
                return 1;
            }
            case "LUTY" -> {
                return 2;
            }
            case "MARZEC" -> {
                return 3;
            }
            case "KWIECIEŃ" -> {
                return 4;
            }
            case "MAJ" -> {
                return 5;
            }
            case "CZERWIEC" -> {
                return 6;
            }
            case "LIPIEC" -> {
                return 7;
            }
            case "SIERPIEŃ" -> {
                return 8;
            }
            case "WRZESIEŃ" -> {
                return 9;
            }
            case "PAŹDZIERNIK" -> {
                return 10;
            }
            case "LISTOPAD" -> {
                return 11;
            }
            case "GRUDZIEŃ" -> {
                return 12;
            }
        }
        return 1;
    }
}
