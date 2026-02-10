package com.practice.problem14.models;

import com.practice.problem14.interfaces.Ticketable;

/**
 * Represents a movie.
 */
public class Movie implements Ticketable {
    /**
     * Construct a movie.
     * @param movieId movie id
     * @param title movie title
     * @param date show date
     * @param capacity total tickets
     */
    public Movie(String movieId, String title, String date, int capacity) {
        throw new UnsupportedOperationException("TODO");
    }

    public String getMovieId() {
        throw new UnsupportedOperationException("TODO");
    }

    public String getTitle() {
        throw new UnsupportedOperationException("TODO");
    }

    public String getDate() {
        throw new UnsupportedOperationException("TODO");
    }

    public int getCapacity() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void book() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void cancel() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean isBooked() {
        throw new UnsupportedOperationException("TODO");
    }
}