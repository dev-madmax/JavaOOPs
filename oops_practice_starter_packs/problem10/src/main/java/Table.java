import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Table implements Reservable {
    private int tableNumber;
    private int capacity;
    private List<Reservation> reservations;

    public Table(int tableNumber, int capacity) {
        if (capacity < 2 || capacity > 10) {
            throw new IllegalArgumentException("Capacity must be between 2 and 10");
        }
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.reservations = new ArrayList<>();
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean isAvailable(LocalDateTime start, int durationMinutes) {
        LocalDateTime newEnd = start.plusMinutes(durationMinutes);
        
        for (Reservation reservation : reservations) {
            LocalDateTime existingStart = reservation.getStartTime();
            LocalDateTime existingEnd = reservation.getEndTime();
            
            // Check for overlap: new reservation starts before existing ends AND new reservation ends after existing starts
            if (start.isBefore(existingEnd) && newEnd.isAfter(existingStart)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void reserve(LocalDateTime start, int durationMinutes, int partySize) throws TableUnavailableException {
        if (partySize > capacity) {
            throw new InvalidPartySizeException("Party size exceeds table capacity");
        }
        
        if (!isAvailable(start, durationMinutes)) {
            throw new TableUnavailableException("Table is not available for the requested time slot");
        }
        
        Reservation newReservation = new Reservation(partySize, start, durationMinutes);
        reservations.add(newReservation);
    }

    public List<Reservation> getReservations() {
        return Collections.unmodifiableList(reservations);
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableNumber=" + tableNumber +
                ", capacity=" + capacity +
                ", reservationCount=" + reservations.size() +
                '}';
    }
}