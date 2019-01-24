import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

// lul
class Periods {
    public static void main(String args[]) {
        // Periods used for LocalDate and LocalDateTime
        // Periods are a way of storing an amount of time

        // You can't chain period methods, instead use of(year, month, day)
        Period period = Period.of(1, 1, 1);
        Period months = Period.ofMonths(2);

        // Periods are formatted P1Y1M1D
        // Zeros are omitted e.g. P2M
        System.out.println(period);
        System.out.println(months);

        Period days = Period.ofDays(2);
        // This will be formatted as PD14 as week is not displayed
        Period weeks = Period.ofWeeks(2);
        Period years = Period.ofYears(2);

        LocalDate startDate = LocalDate.of(1996, Month.JUNE, 07);
        LocalDate endDate = LocalDate.of(1996, Month.JULY, 07);

        while (startDate.isBefore(endDate)) {
            startDate = startDate.plus(weeks);
            System.out.println(startDate);
        }
    }
}