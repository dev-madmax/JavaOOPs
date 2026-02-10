# Problem 9: Gym Membership System

## Problem Description
Model gym memberships with tiers (`BasicTier`, `PremiumTier`) granting different privileges. Teaches: Composition over inheritance (Strategy pattern), Interface abstraction, Encapsulation of visit history.

## OOP Concepts Required
- Composition: `Member` HAS a `MemberTier` (not inheritance)
- Abstraction: `MemberTier` interface defines tier behavior
- Strategy Pattern: Tier behavior injected into Member
- Encapsulation: Visit history stored privately; accessed via methods

## Interfaces
```java
public interface MemberTier {
    int getMaxDailyVisits();
    boolean hasPoolAccess();
}
```

## Classes
- `BasicTier` implements `MemberTier`
  - `getMaxDailyVisits()` returns `1`
  - `hasPoolAccess()` returns `false`
- `PremiumTier` implements `MemberTier`
  - `getMaxDailyVisits()` returns `3`
  - `hasPoolAccess()` returns `true`
- `Member`
  - Fields: `private int id`, `private String name`, `private MemberTier tier`, `private List<LocalDateTime> visits`
- `Gym`
  - Fields: `private String name`, `private List<Member> members`

## Constructors
- `BasicTier()`
- `PremiumTier()`
- `Member(int id, String name, MemberTier tier)` – initializes empty visits list
- `Gym(String name)` – initializes empty member list

## Methods to Implement
1. `Gym.registerMember(Member member)`
2. `Gym.checkInMember(int memberId, LocalDateTime time)` – validates visit limit before adding
3. `Member.getTodayVisitCount(LocalDate date)` – counts visits where `visit.toLocalDate().equals(date)`
4. `Member.canAccessPool()` – delegates to `tier.hasPoolAccess()`
5. `Gym.getMembersCheckedInToday(LocalDate date)` – returns members with visits today

## Exceptions
- `VisitLimitExceededException extends Exception`

## Grading Focus
- Composition: Member contains Tier (not Member extends Tier)
- Delegation: `canAccessPool()` calls `tier.hasPoolAccess()`
- Date extraction: `visit.toLocalDate()` to compare days
- Validation BEFORE state change (check limit before adding visit)