import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ExtractOfAccount {

    // LocalDate	            Represents a date (year, month, day (yyyy-MM-dd))
    // LocalTime     	        Represents a time (hour, minute, second and nanoseconds (HH-mm-ss-ns))
    // LocalDateTime	        Represents both a date and a time (yyyy-MM-dd-HH-mm-ss-ns)
    // DateTimeFormatter	    Formatter for displaying and parsing date-time objects

    private String idNumber;
    private LocalDate dt;
    private LocalTime tm;
    private String action;
    private double amount;


    public ExtractOfAccount() {
    }

    public ExtractOfAccount(String action, double amount) {
        this.dt = LocalDate.now();
        this.tm = LocalTime.now();
        this.action = action;
        this.amount = amount;
    }

    public LocalDate getDt() {
        return dt;
    }

    public void setDt(LocalDate dt) {
        this.dt = LocalDate.now();
    }

    public LocalTime getTm() {
        return tm;
    }

    public void setTm(LocalTime tm) {
        this.tm = LocalTime.now();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ExtractOfAccount{" +
                "dt=" + dt +
                ", tm=" + tm +
                ", action='" + action + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
