package com.practice.problem8.evaluator;

import com.practice.problem8.services.*;
import com.practice.problem8.models.*;
import com.practice.problem8.exceptions.*;

/**
 * 🔒 LOCKED -- Students must not edit this file!
 *
 * Evaluates implementations for Music Playlist Manager.
 * Run via Main.java.
 */
public class Evaluator {
    public static void run() {
        int passed = 0;
        int total = 22;

        try {
            PlaylistService service = new PlaylistService();

            // 1. Add song
            Song s1 = new Song("Bohemian Rhapsody", "Queen", 354);
            service.addSong(s1);
            passed++;

            // 2. Add another song
            Song s2 = new Song("Imagine", "John Lennon", 183);
            service.addSong(s2);
            passed++;

            // 3. Duplicate song throws
            try {
                service.addSong(new Song("Bohemian Rhapsody", "Queen", 400));
                throw new RuntimeException("Duplicate song not detected");
            } catch (DuplicateSongException ex) {
                passed++;
            }

            // 4. Create playlist
            Playlist playlist = service.createPlaylist("MyFavorites");
            passed++;

            // 5. Add song to playlist
            service.addSongToPlaylist("Bohemian Rhapsody", "MyFavorites");
            passed++;

            // 6. Add duplicate song to playlist throws
            try {
                service.addSongToPlaylist("Bohemian Rhapsody", "MyFavorites");
                throw new RuntimeException("Duplicate playlist entry not detected");
            } catch (InvalidPlaylistOperationException ex) {
                passed++;
            }

            // 7. Add unknown song throws
            try {
                service.addSongToPlaylist("UnknownSong", "MyFavorites");
                throw new RuntimeException("Unknown song not detected");
            } catch (SongNotFoundException ex) {
                passed++;
            }

            // 8. Playable interface
            Playable p = new Song("SongX", "ArtistY", 100);
            if (!p.getClass().getInterfaces()[0].getSimpleName().equals("Playable")) throw new RuntimeException("Interface missing");
            passed++;

            // 9. PlaylistEntry happy
            PlaylistEntry entry = new PlaylistEntry("Bohemian Rhapsody", "MyFavorites");
            if (!entry.getSongTitle().equals("Bohemian Rhapsody")) throw new RuntimeException("PlaylistEntry wrong");
            passed++;

            // 10. Remove song from playlist happy
            service.removeSongFromPlaylist("Bohemian Rhapsody", "MyFavorites");
            try {
                service.removeSongFromPlaylist("Bohemian Rhapsody", "MyFavorites");
                throw new RuntimeException("Song not removed from playlist");
            } catch (InvalidPlaylistOperationException ex) {
                passed++;
            }

            // 11. Playlist boundary: create duplicate playlist throws
            try {
                service.createPlaylist("MyFavorites");
                throw new RuntimeException("Duplicate playlist not detected");
            } catch (InvalidPlaylistOperationException ex) {
                passed++;
            }

            // 12. Remove playlist happy
            service.removePlaylist("MyFavorites");
            try {
                service.addSongToPlaylist("Imagine", "MyFavorites");
                throw new RuntimeException("Removed playlist allowed");
            } catch (InvalidPlaylistOperationException ex) {
                passed++;
            }

            // 13. Remove unknown song throws
            try {
                service.removeSong("UnknownSong");
                throw new RuntimeException("Remove unknown song not detected");
            } catch (SongNotFoundException ex) {
                passed++;
            }

            // 14. Null song throws
            try {
                service.addSong(null);
                throw new RuntimeException("Null song not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 15. Null playlist throws
            try {
                service.createPlaylist(null);
                throw new RuntimeException("Null playlist not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 16. Defensive: add many songs/playlists
            for (int i = 100; i < 120; i++) {
                service.addSong(new Song("Song"+i, "Artist"+i, i));
                service.createPlaylist("Playlist"+i);
                service.addSongToPlaylist("Song"+i, "Playlist"+i);
            }
            passed++;

            // 17. Defensive: remove from playlist many songs
            for (int i = 100; i < 120; i++) {
                service.removeSongFromPlaylist("Song"+i, "Playlist"+i);
            }
            passed++;

            // 18. Remove playlist with songs
            for (int i = 100; i < 110; i++) {
                service.createPlaylist("MegaPlaylist"+i);
                service.addSongToPlaylist("Song"+i, "MegaPlaylist"+i);
            }
            for (int i = 100; i < 110; i++) {
                service.removePlaylist("MegaPlaylist"+i);
            }
            passed++;

            // 19. Defensive: remove song removes from all playlists
            service.addSong(new Song("SharedSong", "SharedArtist", 200));
            service.createPlaylist("P1");
            service.createPlaylist("P2");
            service.addSongToPlaylist("SharedSong", "P1");
            service.addSongToPlaylist("SharedSong", "P2");
            service.removeSong("SharedSong");
            try {
                service.removeSongFromPlaylist("SharedSong", "P1");
                throw new RuntimeException("Song not removed from playlist on song removal");
            } catch (SongNotFoundException ex) {
                passed++;
            }

            // 20. Defensive: playlist boundaries
            try {
                service.createPlaylist("");
                throw new RuntimeException("Empty playlist name not detected");
            } catch (InvalidPlaylistOperationException ex) {
                passed++;
            }

            // 21. Defensive: song boundaries
            try {
                service.addSong(new Song("", "ArtistZ", 50));
                throw new RuntimeException("Empty song title not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 22. Defensive: add large playlists/songs
            for (int i = 1000; i < 1050; i++) {
                service.addSong(new Song("BigSong"+i, "BigArtist"+i, i));
                service.createPlaylist("BigP"+i);
                service.addSongToPlaylist("BigSong"+i, "BigP"+i);
            }
            passed++;

            System.out.println("ALL TESTS PASSED");
        } catch (RuntimeException ex) {
            System.out.println("FAILED TESTS: " + (total - passed) + " / " + total);
            throw ex;
        }
    }
}