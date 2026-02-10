import java.util.List;
import java.util.ArrayList;

public class MusicLibrary {
    private List<Song> catalog;
    private List<Playlist> playlists;

    public MusicLibrary() {
        this.catalog = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    public void addSongToCatalog(Song song) {
        catalog.add(song);
    }

    public Playlist createPlaylist(String name, int maxDuration) {
        Playlist playlist = new Playlist(name, maxDuration);
        playlists.add(playlist);
        return playlist;
    }

    public List<Song> getCatalog() {
        return new ArrayList<>(catalog);
    }

    public List<Playlist> getPlaylists() {
        return new ArrayList<>(playlists);
    }

    @Override
    public String toString() {
        return "MusicLibrary{" +
                "catalog=" + catalog +
                ", playlists=" + playlists +
                '}';
    }
}