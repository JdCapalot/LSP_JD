package org.howard.edu.finalexam.problem;

import java.util.*;

/**
 * Custom song database class.
 * 
 * @author Justin
 */
public class SongsDatabase {
    private HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();

    /**
     * Adds a song title to a genre or creates a new genre starting with that song.
     * 
     * @param genre the genre to add the song to
     * @param title the song title to add
     */
    public void addSong(String genre, String title) {
        HashSet<String> songSet = map.get(genre);
        if (songSet == null) {
            songSet = new HashSet<String>();
            map.put(genre, songSet);
        }
        songSet.add(title);
    }

    /**
     * Returns a Set containing all songs for a genre.
     * 
     * @param genre the genre to get the songs from
     * @return the set of songs in that genre
     */
    public Set<String> getSongs(String genre) {
        HashSet<String> songSet = map.get(genre);
        if (songSet == null) {
            songSet = new HashSet<String>();
        }
        return songSet;
    }

    /**
     * Returns the genre of a given song title.
     * 
     * @param title the song title to find the genre for
     * @return the genre associated with the song, or an error message if not found
     */
    public String getGenre(String title) {
        for (String genre : map.keySet()) {
            HashSet<String> songSet = map.get(genre);
            if (songSet.contains(title)) {
                return genre;
            }
        }
        return "That song is not in the Database.";
    }
}
