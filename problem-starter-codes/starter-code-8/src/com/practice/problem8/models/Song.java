package com.practice.problem8.models;

import com.practice.problem8.interfaces.Playable;

/**
 * Represents a song.
 */
public class Song implements Playable {
    /**
     * Construct a song with title, artist, and duration.
     * @param title song title
     * @param artist song artist
     * @param duration song duration (sec)
     */
    public Song(String title, String artist, int duration) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get title.
     * @return title
     */
    @Override
    public String getTitle() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get artist.
     * @return artist
     */
    public String getArtist() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get duration.
     * @return duration
     */
    @Override
    public int getDuration() {
        throw new UnsupportedOperationException("TODO");
    }
}