package com.practice.problem10.interfaces;

public interface Reservable {
    public void reserve(String date, String time);
    public void unreserve();
    public boolean isReserved();
}
