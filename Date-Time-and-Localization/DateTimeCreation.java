
// Required import for date/ time API
import java.time.*;
import java.util.TimeZone;

public class DateTimeCreation {
    public static void main(String[] args) {
        currentDateTime();
        specificDateTime();
    }

    // now function gives us the date/time... now
    public static void currentDateTime() {
        // Just the date
        LocalDate date = LocalDate.now();
        System.out.println("LocalDate now: " + date);

        // Just the time
        LocalTime time = LocalTime.now();
        System.out.println("LocalTime now: " + time);

        // Date and time
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("LocalDateTime now: " + dateTime);

        // Date, time and time zone! Fancy
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("ZonedDateTime now: " + zonedDateTime);
        System.out.println();
    }

    public static void specificDateTime() {
        // Can specify localDate with month enum or int
        LocalDate date = LocalDate.of(1996, Month.JUNE, 07);
        LocalDate date2 = LocalDate.of(1996, 06, 07);
        System.out.println("Specific localDate: " + date + ", " + date2);

        LocalTime time = LocalTime.of(12, 05);
        // Can specify seconds and nano seconds
        LocalTime time2 = LocalTime.of(12, 05, 10, 10);
        System.out.println("Specific localTime: " + time + ", " + time2);

        // Can create localDateTime with all values or by combining a localDate and
        // localTime
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        LocalDateTime dateTime2 = LocalDateTime.of(1996, Month.JUNE, 07, 12, 05, 10, 10);
        System.out.println("Specific localDateTime: " + dateTime + ", " + dateTime2);

        // Can create zonedDateTime with localDateTime and zoneID
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, TimeZone.getDefault().toZoneId());
        // Can create with localDate, localTime and zoneID
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(date, time, TimeZone.getDefault().toZoneId());
        // Can with with all values specified, however no constructor for enum month and
        // must specify seconds and nano-seconds
        ZoneId zone = ZoneId.of("US/ Eastern");
        ZoneId defaultZone = TimeZone.getDefault().toZoneId();
        ZonedDateTime zonedDateTime3 = ZonedDateTime.of(1996, 06, 07, 12, 05, 10, 10, defaultZone);
        System.out.println();
        System.out.println("Specific Zoned DateTime:");
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime2);
        System.out.println(zonedDateTime3);
    }
}