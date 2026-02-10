public class BasicTier implements MemberTier {
    @Override
    public int getMaxDailyVisits() {
        return 1;
    }

    @Override
    public boolean hasPoolAccess() {
        return false;
    }
}