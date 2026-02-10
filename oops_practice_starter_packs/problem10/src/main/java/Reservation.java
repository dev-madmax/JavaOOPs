import java.time.LocalDateTime;

public class Reservation {
    private int partySize;
    private LocalDateTime startTime;
    private int durationMinutes;

    public Reservation(int partySize, LocalDateTime startTime, int durationMinutes) {
        if (partySize <= 0) {
            throw new IllegalArgumentException("Party size must be positive");
        }
        this.partySize = partySize;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
    }

    public int getPartySize() {
        return partySize;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public LocalDateTime getEndTime() {
        return startTime.plusMinutes(durationMinutes);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "partySize=" + partySize +
                ", startTime=" + startTime +
                ", durationMinutes=" + durationMinutes +
                ", endTime=" + getEndTime() +
                '}';
    }
}