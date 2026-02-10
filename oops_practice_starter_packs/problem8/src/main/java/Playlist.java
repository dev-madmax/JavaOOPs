import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Playlist {
    private String name;
    private int maxDurationSeconds;
    private List<Song> songs;

    public Playlist(String name, int maxDurationSeconds) {
        if (maxDurationSeconds <= 0) {
            throw new IllegalArgumentException("Max duration must be positive");
        }
        this.name = name;
        this.maxDurationSeconds = maxDurationSeconds;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMaxDurationSeconds() {
        return maxDurationSeconds;
    }

    public boolean addSong(Song song) throws DuplicateSongException, PlaylistFullException {
        // Check for duplicate
        if (songs.contains(song)) {
            throw new DuplicateSongException("Song already exists in playlist");
        }

        // Check duration limit
        int totalDuration = getTotalDuration() + song.getDurationSeconds();
        if (totalDuration > maxDurationSeconds) {
            throw new PlaylistFullException("Adding this song would exceed the duration limit");
        }

        return songs.add(song);
    }

    public boolean removeSong(String title) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equalsIgnoreCase(title)) {
                songs.remove(i);
                return true;
            }
        }
        return false;
    }

    public int getTotalDuration() {
        int total = 0;
        for (Song song : songs) {
            total += song.getDurationSeconds();
        }
        return total;
    }

    public boolean containsSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    public List<Song> getSongs() {
        return Collections.unmodifiableList(songs);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "name='" + name + '\'' +
                ", maxDurationSeconds=" + maxDurationSeconds +
                ", songs=" + songs +
                '}';
    }
}