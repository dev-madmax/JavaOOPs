public class MusicPlaylistTest {
    public static void main(String[] args) {
        try {
            // Test case 1: Creating a song with valid parameters
            Song song1 = new Song("Bohemian Rhapsody", "Queen", 354);
            assert song1.getTitle().equals("Bohemian Rhapsody") : "Title should match";
            assert song1.getArtist().equals("Queen") : "Artist should match";
            assert song1.getDurationSeconds() == 354 : "Duration should match";
            System.out.println("Test 1 passed: Song creation");

            // Test case 2: Creating a playlist with valid parameters
            Playlist playlist = new Playlist("My Favorites", 1000);
            assert playlist.getName().equals("My Favorites") : "Playlist name should match";
            assert playlist.getMaxDurationSeconds() == 1000 : "Max duration should match";
            assert playlist.getTotalDuration() == 0 : "Initial duration should be 0";
            System.out.println("Test 2 passed: Playlist creation");

            // Test case 3: Adding a song to playlist
            playlist.addSong(song1);
            assert playlist.getTotalDuration() == 354 : "Duration should update after adding song";
            assert playlist.containsSong("Bohemian Rhapsody") : "Playlist should contain added song";
            assert !playlist.containsSong("Imagine") : "Playlist should not contain non-added song";
            System.out.println("Test 3 passed: Adding song to playlist");

            // Test case 4: Testing duplicate song exception
            Song song2 = new Song("Bohemian Rhapsody", "Queen", 400); // Same title and artist, different duration
            boolean duplicateThrown = false;
            try {
                playlist.addSong(song2);
            } catch (DuplicateSongException e) {
                duplicateThrown = true;
            }
            assert duplicateThrown : "Should throw DuplicateSongException for duplicate song";
            assert playlist.getSongs().size() == 1 : "Playlist should still have only one song";
            System.out.println("Test 4 passed: Duplicate song detection");

            // Test case 5: Adding multiple songs and testing duration limit
            Song song3 = new Song("Hotel California", "Eagles", 390);
            playlist.addSong(song3);
            assert playlist.getTotalDuration() == 744 : "Duration should update after adding second song";
            
            // Try to add a song that would exceed the duration limit
            Song song4 = new Song("Sweet Child O' Mine", "Guns N' Roses", 300);
            boolean limitThrown = false;
            try {
                playlist.addSong(song4);
            } catch (PlaylistFullException e) {
                limitThrown = true;
            }
            assert limitThrown : "Should throw PlaylistFullException when exceeding duration limit";
            assert playlist.getTotalDuration() == 744 : "Duration should remain unchanged";
            System.out.println("Test 5 passed: Duration limit enforcement");

            // Test case 6: Remove song functionality
            boolean removed = playlist.removeSong("Bohemian Rhapsody");
            assert removed : "Should successfully remove existing song";
            assert !playlist.containsSong("Bohemian Rhapsody") : "Playlist should not contain removed song";
            assert playlist.getTotalDuration() == 390 : "Duration should update after removing song";
            
            boolean notRemoved = playlist.removeSong("Non-existent Song");
            assert !notRemoved : "Should not remove non-existent song";
            System.out.println("Test 6 passed: Remove song functionality");

            // Test case 7: Song equality and hash code
            Song song5 = new Song("Bohemian Rhapsody", "Queen", 354);
            Song song6 = new Song("bohemian rhapsody", "queen", 300); // Case insensitive comparison
            assert song5.equals(song6) : "Songs should be equal regardless of case";
            assert song5.hashCode() == song6.hashCode() : "Equal songs should have same hash code";
            
            Song song7 = new Song("Imagine", "John Lennon", 183);
            assert !song5.equals(song7) : "Different songs should not be equal";
            System.out.println("Test 7 passed: Song equality and hash code");

            // Test case 8: MusicLibrary functionality
            MusicLibrary library = new MusicLibrary();
            Playlist newPlaylist = library.createPlaylist("Rock Classics", 2000);
            assert newPlaylist.getName().equals("Rock Classics") : "Created playlist should have correct name";
            assert library.getPlaylists().size() == 1 : "Library should contain the new playlist";
            
            library.addSongToCatalog(song1);
            library.addSongToCatalog(song3);
            assert library.getCatalog().size() == 2 : "Library catalog should contain added songs";
            System.out.println("Test 8 passed: MusicLibrary functionality");

            // Test case 9: Edge case - empty playlist
            Playlist emptyPlaylist = new Playlist("Empty", 500);
            assert emptyPlaylist.getTotalDuration() == 0 : "Empty playlist should have 0 duration";
            assert !emptyPlaylist.containsSong("Any Song") : "Empty playlist should not contain any songs";
            System.out.println("Test 9 passed: Empty playlist edge case");

            // Test case 10: Playlist with exact duration limit
            Playlist tightPlaylist = new Playlist("Tight Fit", 200);
            Song exactFitSong = new Song("Short Song", "Artist", 200);
            tightPlaylist.addSong(exactFitSong);
            assert tightPlaylist.getTotalDuration() == 200 : "Playlist should accept song that fits exactly";
            
            Song overLimitSong = new Song("Another Song", "Artist", 1);
            boolean exactLimitThrown = false;
            try {
                tightPlaylist.addSong(overLimitSong);
            } catch (PlaylistFullException e) {
                exactLimitThrown = true;
            }
            assert exactLimitThrown : "Should reject song that exceeds exact limit";
            System.out.println("Test 10 passed: Exact duration limit");

            System.out.println("All tests passed!");
        } catch (Exception e) {
            System.err.println("Unexpected exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}