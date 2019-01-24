import java.time.*;
import java.time.Month;

class DateTimeManipulation {
    public static void main(String args[]) {
        LocalDate date = LocalDate.of(1996, Month.JUNE, 07);
        System.out.println(date);

        date = date.plusDays(1);
        date = date.plusWeeks(1);
        date = date.plusMonths(1);
        date = date.plusYears(1);
        // Date Time objects are immutable! Required to reasign date when calling
        // functions
        System.out.println(date);

        // date = date.minusDays(-1);
        date = date.minusDays(1);
        date = date.minusWeeks(1);
        date = date.minusMonths(1);
        date = date.minusYears(1);
        System.out.println(date);

        LocalTime time = LocalTime.of(10, 30);
        time = time.plusHours(1);
        time = time.plusMinutes(1);
        time = time.plusSeconds(1);
        time = time.plusNanos(1);

        // Can't do date operations on LocalTime and visa vera
        // This won't work
        // time = time.plusWeek(1);
        // Can do everything on LocalDateTime
    }
}