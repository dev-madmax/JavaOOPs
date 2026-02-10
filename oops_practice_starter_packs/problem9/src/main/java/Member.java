import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Member {
    private int id;
    private String name;
    private MemberTier tier;
    private List<LocalDateTime> visits;

    public Member(int id, String name, MemberTier tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
        this.visits = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MemberTier getTier() {
        return tier;
    }

    public boolean canAccessPool() {
        return tier.hasPoolAccess();
    }

    public int getTodayVisitCount(LocalDate date) {
        int count = 0;
        for (LocalDateTime visit : visits) {
            if (visit.toLocalDate().equals(date)) {
                count++;
            }
        }
        return count;
    }

    public void addVisit(LocalDateTime time) {
        visits.add(time);
    }

    public List<LocalDateTime> getVisits() {
        return new ArrayList<>(visits);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier.getClass().getSimpleName() +
                ", visitCount=" + visits.size() +
                '}';
    }
}