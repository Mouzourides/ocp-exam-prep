import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Instants {
    public static void main(String args[]) throws InterruptedException {
        // Instant represents a moment in time in GMT time zone
        Instant now = Instant.now();
        // Something time consuming
        Thread.sleep(1000);
        Instant later = Instant.now();

        Duration duration = Duration.between(now, later);
        System.out.println(duration);

        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime usTime = ZonedDateTime.of(LocalDate.of(1996, Month.JUNE, 07), LocalTime.of(13, 00), zone);

        // You can use instant to convert different timezones to GMT
        Instant instant = usTime.toInstant();
        System.out.println("These are the same: " + instant + ", " + usTime);

        // Instants allow you to add any unit smaller than a day
        System.out.println(instant.plus(1, ChronoUnit.DAYS));

        // This won't work, doesn't work with units higher than days
        // instant.plus(1, ChronoUnit.MONTHS);
    }
}