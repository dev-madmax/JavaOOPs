import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public interface Reservable {
    boolean isAvailable(LocalDateTime start, int durationMinutes);
    void reserve(LocalDateTime start, int durationMinutes, int partySize) throws TableUnavailableException;
}