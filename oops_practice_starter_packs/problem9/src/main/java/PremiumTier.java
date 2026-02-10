public class PremiumTier implements MemberTier {
    @Override
    public int getMaxDailyVisits() {
        return 3;
    }

    @Override
    public boolean hasPoolAccess() {
        return true;
    }
}