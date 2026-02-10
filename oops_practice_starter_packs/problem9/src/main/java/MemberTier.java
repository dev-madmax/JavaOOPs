import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public interface MemberTier {
    int getMaxDailyVisits();
    boolean hasPoolAccess();
}