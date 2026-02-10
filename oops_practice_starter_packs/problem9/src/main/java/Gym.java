import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Gym {
    private String name;
    private List<Member> members;

    public Gym(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public void checkInMember(int memberId, LocalDateTime time) throws VisitLimitExceededException {
        Member member = findMemberById(memberId);
        if (member == null) {
            throw new IllegalArgumentException("Member not found: " + memberId);
        }

        // Check if the member has exceeded their daily visit limit
        int currentDayVisits = member.getTodayVisitCount(time.toLocalDate());
        if (currentDayVisits >= member.getTier().getMaxDailyVisits()) {
            throw new VisitLimitExceededException("Member " + memberId + " has reached daily visit limit");
        }

        // Add the visit
        member.addVisit(time);
    }

    public List<Member> getMembersCheckedInToday(LocalDate date) {
        return members.stream()
                .filter(member -> member.getTodayVisitCount(date) > 0)
                .collect(Collectors.toList());
    }

    private Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getId() == memberId) {
                return member;
            }
        }
        return null;
    }

    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }

    @Override
    public String toString() {
        return "Gym{" +
                "name='" + name + '\'' +
                ", members=" + members +
                '}';
    }
}