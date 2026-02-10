package com.practice.problem9.models;

import com.practice.problem9.interfaces.Subscribable;

/**
 * Represents a gym member.
 */
public class Member implements Subscribable {
    /**
     * Construct a member with id and name.
     * @param memberId member id
     * @param name member name
     */
    public Member(int memberId, String name) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get member id.
     * @return memberId
     */
    @Override
    public int getMemberId() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get member name.
     * @return name
     */
    public String getName() {
        throw new UnsupportedOperationException("TODO");
    }
}