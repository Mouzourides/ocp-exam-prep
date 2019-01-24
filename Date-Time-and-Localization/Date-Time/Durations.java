import java.time.*;
import java.time.temporal.ChronoUnit;

public class Durations {
    public static void main(String args[]) {
        // Durations used for LocalTime or LocalDateTime

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime birth = LocalDateTime.of(LocalDate.of(1996, 06, 07), LocalTime.now());

        // Formatted as PTxHxMxS [period time][hours][mins][seconds]
        Duration days = Duration.ofDays(1);
        Duration hours = Duration.ofHours(1);
        Duration minutes = Duration.ofMinutes(1);
        Duration seconds = Duration.ofSeconds(1);
        Duration miliseconds = Duration.ofMillis(1);
        Duration nanoseconds = Duration.ofNanos(1);

        // Prints PT24H
        System.out.println(days);
        now = now.plus(days);

        // ChronoUnits, provide a nice way of specifiying units of time
        ChronoUnit halfDay = ChronoUnit.HALF_DAYS;
        Duration duration = Duration.of(1, halfDay);

        // ChronoUnits also provide a way of determining the difference between time
        // date objects
        System.out.println("I've been alive " + ChronoUnit.HOURS.between(birth, now) + " hours");
    }
}