import java.util.List;
import java.util.ArrayList;

public class Song implements Playable {
    private String title;
    private String artist;
    private int durationSeconds;

    public Song(String title, String artist, int durationSeconds) {
        if (durationSeconds <= 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }
        this.title = title;
        this.artist = artist;
        this.durationSeconds = durationSeconds;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public int getDurationSeconds() {
        return durationSeconds;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Song song = (Song) obj;
        return this.title.equalsIgnoreCase(song.title) && 
               this.artist.equalsIgnoreCase(song.artist);
    }

    @Override
    public int hashCode() {
        return (title.toLowerCase() + artist.toLowerCase()).hashCode();
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", durationSeconds=" + durationSeconds +
                '}';
    }
}