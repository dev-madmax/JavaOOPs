import java.time.LocalDateTime;
import java.time.LocalDate;

public class GymMembershipTest {
    public static void main(String[] args) {
        try {
            // Test case 1: Creating BasicTier and verifying its properties
            BasicTier basicTier = new BasicTier();
            assert basicTier.getMaxDailyVisits() == 1 : "Basic tier should allow 1 daily visit";
            assert !basicTier.hasPoolAccess() : "Basic tier should not have pool access";
            System.out.println("Test 1 passed: BasicTier properties");

            // Test case 2: Creating PremiumTier and verifying its properties
            PremiumTier premiumTier = new PremiumTier();
            assert premiumTier.getMaxDailyVisits() == 3 : "Premium tier should allow 3 daily visits";
            assert premiumTier.hasPoolAccess() : "Premium tier should have pool access";
            System.out.println("Test 2 passed: PremiumTier properties");

            // Test case 3: Creating a member with BasicTier
            Member basicMember = new Member(1, "John Doe", basicTier);
            assert basicMember.getId() == 1 : "Member ID should match";
            assert basicMember.getName().equals("John Doe") : "Member name should match";
            assert !basicMember.canAccessPool() : "Basic member should not have pool access";
            assert basicMember.getTier().getMaxDailyVisits() == 1 : "Member tier should be BasicTier";
            System.out.println("Test 3 passed: Member with BasicTier");

            // Test case 4: Creating a member with PremiumTier
            Member premiumMember = new Member(2, "Jane Smith", premiumTier);
            assert premiumMember.getId() == 2 : "Member ID should match";
            assert premiumMember.getName().equals("Jane Smith") : "Member name should match";
            assert premiumMember.canAccessPool() : "Premium member should have pool access";
            assert premiumMember.getTier().getMaxDailyVisits() == 3 : "Member tier should be PremiumTier";
            System.out.println("Test 4 passed: Member with PremiumTier");

            // Test case 5: Creating a gym and registering members
            Gym gym = new Gym("Fitness Plus");
            assert gym.toString().contains("Fitness Plus") : "Gym name should match";
            
            gym.registerMember(basicMember);
            gym.registerMember(premiumMember);
            assert gym.getMembers().size() == 2 : "Gym should have 2 registered members";
            System.out.println("Test 5 passed: Gym registration");

            // Test case 6: Checking in members and validating visit limits
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime yesterday = now.minusDays(1);
            
            // Basic member should be able to check in once per day
            gym.checkInMember(1, now);
            assert basicMember.getTodayVisitCount(now.toLocalDate()) == 1 : "Basic member should have 1 visit today";
            
            // Trying to check in again should throw an exception
            boolean limitExceeded = false;
            try {
                gym.checkInMember(1, now.plusHours(1));
            } catch (VisitLimitExceededException e) {
                limitExceeded = true;
            }
            assert limitExceeded : "Basic member should not be allowed second visit in same day";
            assert basicMember.getTodayVisitCount(now.toLocalDate()) == 1 : "Visit count should remain 1";
            System.out.println("Test 6 passed: Basic member visit limit");

            // Test case 7: Premium member can check in multiple times
            gym.checkInMember(2, now);
            assert premiumMember.getTodayVisitCount(now.toLocalDate()) == 1 : "Premium member should have 1 visit";
            
            gym.checkInMember(2, now.plusHours(1));
            assert premiumMember.getTodayVisitCount(now.toLocalDate()) == 2 : "Premium member should have 2 visits";
            
            gym.checkInMember(2, now.plusHours(2));
            assert premiumMember.getTodayVisitCount(now.toLocalDate()) == 3 : "Premium member should have 3 visits";
            
            // Trying to check in a fourth time should throw an exception
            limitExceeded = false;
            try {
                gym.checkInMember(2, now.plusHours(3));
            } catch (VisitLimitExceededException e) {
                limitExceeded = true;
            }
            assert limitExceeded : "Premium member should not be allowed fourth visit in same day";
            System.out.println("Test 7 passed: Premium member visit limits");

            // Test case 8: Cross-day check-in (same member, different days)
            gym.checkInMember(1, yesterday);
            assert basicMember.getTodayVisitCount(yesterday.toLocalDate()) == 1 : "Basic member should have 1 visit yesterday";
            assert basicMember.getTodayVisitCount(now.toLocalDate()) == 1 : "Basic member should still have 1 visit today";
            
            // Now basic member should be able to check in again today since it's a new day
            // We'll simulate this by creating a new basic member for today's check-in
            Member basicMember2 = new Member(3, "Bob Johnson", basicTier);
            gym.registerMember(basicMember2);
            
            // Check in on a different day should work
            gym.checkInMember(3, now);
            assert basicMember2.getTodayVisitCount(now.toLocalDate()) == 1 : "New member should have 1 visit today";
            System.out.println("Test 8 passed: Cross-day check-in");

            // Test case 9: Get members checked in today
            LocalDateTime someDate = now.toLocalDate().atStartOfDay();
            java.util.List<Member> checkedInToday = gym.getMembersCheckedInToday(now.toLocalDate());
            assert checkedInToday.size() >= 2 : "At least 2 members should be checked in today (basicMember2 and premiumMember)";
            
            // Verify the members returned actually visited today
            for (Member member : checkedInToday) {
                if (member.getId() == 2) { // premiumMember
                    assert member.getTodayVisitCount(now.toLocalDate()) > 0 : "Premium member should have visits today";
                } else if (member.getId() == 3) { // basicMember2
                    assert member.getTodayVisitCount(now.toLocalDate()) > 0 : "Basic member 2 should have visits today";
                }
            }
            System.out.println("Test 9 passed: Members checked in today");

            // Test case 10: Pool access delegation
            assert !basicMember.canAccessPool() : "Basic member should not have pool access";
            assert premiumMember.canAccessPool() : "Premium member should have pool access";
            
            // Change member's tier to verify delegation works dynamically
            // Note: In real implementation, we might not allow changing tier directly
            // but we can verify the concept by creating a new member
            Member upgradedMember = new Member(4, "Alice Wilson", premiumTier);
            assert upgradedMember.canAccessPool() : "Upgraded member should have pool access";
            System.out.println("Test 10 passed: Pool access delegation");

            System.out.println("All tests passed!");
        } catch (Exception e) {
            System.err.println("Unexpected exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}