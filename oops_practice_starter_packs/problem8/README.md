# Problem 8: Music Playlist Manager

## Problem Description
Manage playlists with songs. Enforce no duplicates and max duration limits. Teaches: Encapsulation of collections, Interface abstraction, Composition (Playlist aggregates Songs), Proper equals()/hashCode().

## OOP Concepts Required
- Encapsulation: Song list private; no direct access
- Abstraction: `Playable` interface for media items
- Composition: `Playlist` HAS multiple `Song` objects
- Object Equality: Proper `equals()`/`hashCode()` implementation for `Song`

## Interfaces
```java
public interface Playable {
    String getTitle();
    int getDurationSeconds();
}
```

## Classes
- `Song` implements `Playable`
  - Fields: `private String title`, `private String artist`, `private int durationSeconds`
- `Playlist`
  - Fields: `private String name`, `private int maxDurationSeconds`, `private List<Song> songs`
- `MusicLibrary`
  - Fields: `private List<Song> catalog`, `private List<Playlist> playlists`

## Constructors
- `Song(String title, String artist, int durationSeconds)` – validates `durationSeconds > 0`
- `Playlist(String name, int maxDurationSeconds)` – validates `maxDurationSeconds > 0`
- `MusicLibrary()` – initializes empty collections

## Methods to Implement
1. `Playlist.addSong(Song song)` – checks duplicate + duration limit before adding
2. `Playlist.removeSong(String title)` – removes first song with matching title
3. `Playlist.getTotalDuration()` – sums `song.getDurationSeconds()`
4. `MusicLibrary.createPlaylist(String name, int maxDuration)`
5. `Playlist.containsSong(String title)` – checks if song title exists in playlist

## Exceptions
- `DuplicateSongException extends Exception`
- `PlaylistFullException extends Exception`

## Grading Focus
- `Song.equals()` based on `title + artist` (case-insensitive)
- `Song.hashCode()` consistent with `equals()`
- Validation BEFORE modification (check limits before adding)
- No exposure of internal list (`getSongs()` returns unmodifiable list)