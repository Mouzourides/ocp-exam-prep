import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DayLightSavings {
    public static void main(String args[]) {
        // In US clocks got forward an hour in March and back an hour in November
        LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time = LocalTime.of(1, 0);
        ZoneId zone = ZoneId.of("US/Eastern");

        // Example of jumping forward an hour
        ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
        System.out.println(dateTime); // 1:00am
        dateTime = dateTime.plusHours(1);
        System.out.println(dateTime); // 3:00am

        System.out.println();

        // Example of jumping back an hour
        LocalDate date2 = LocalDate.of(2016, Month.NOVEMBER, 6);
        LocalTime time2 = LocalTime.of(1, 00);

        ZonedDateTime dateTime2 = ZonedDateTime.of(date2, time2, zone);
        System.out.println(dateTime2); // 1:00am
        dateTime = dateTime.plusHours(1);
        System.out.println(dateTime2); // 1:00am
    }
}