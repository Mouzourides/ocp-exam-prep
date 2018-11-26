
// Required import for date/ time API
import java.time.*;

public class DateTimeCreation {
    public static void main(String[] args) {
        currentDateTime();
        specificDateTime();
    }

    // now function gives us the date/time... now
    public static void currentDateTime() {
        // Just the date
        LocalDate date = LocalDate.now();
        System.out.println(date);

        // Just the time
        LocalTime time = LocalTime.now();
        System.out.println(time);

        // Date and time
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        // Date, time and time zone! Fancy
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }

    public static void specificDateTime() {
        LocalDate date = LocalDate.of(1996, Month.JUNE, 6);
        System.out.println(date);
    }
}