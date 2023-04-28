package org.howard.edu.finalexam.problem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

class SongsDatabaseTest {

    @Test
    public void testAddSongs() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Pop", "Shape of You");
        db.addSong("Rock", "Bohemian Rhapsody");
        db.addSong("Pop", "Bad Romance");
        db.addSong("Rock", "Hotel California");

        Set<String> pop_songs = db.getSongs("Pop");
        Set<String> rock_songs = db.getSongs("Rock");

        assertTrue(pop_songs.contains("Shape of You"));
        assertTrue(rock_songs.contains("Hotel California"));
        assertFalse(pop_songs.contains("Bohemian Rhapsody"));
        assertFalse(rock_songs.contains("Bad Romance"));
        
        System.out.println(db.getGenre("Bohemian Rhapsody"));
        System.out.println(db.getGenre("Shape of You"));
        System.out.println(db.getSongs("Pop"));
        System.out.println(db.getSongs("Rock"));
      
    }

    @Test
    public void testGetSongs() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Jazz", "Take Five");
        db.addSong("Jazz", "So What");
        db.addSong("Blues", "Mannish Boy");
        db.addSong("Blues", "Sweet Little Angel");

        Set<String> jazz_songs = db.getSongs("Jazz");
        assertTrue(jazz_songs.contains("Take Five"));
        assertTrue(jazz_songs.contains("So What"));
        
        System.out.println(db.getGenre("Mannish Boy"));
        System.out.println(db.getGenre("So What"));
        System.out.println(db.getSongs("Jazz"));
        System.out.println(db.getSongs("Blues"));
    }

    @Test
    public void testGetGenre() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Country", "Jolene");
        db.addSong("Country", "Ring of Fire");
        db.addSong("Classical", "Moonlight Sonata");
        db.addSong("Classical", "Air on the G String");

        assertEquals("Classical", db.getGenre("Moonlight Sonata"));
        assertEquals("Country", db.getGenre("Jolene"));
        assertEquals("That song is not in the Database.", db.getGenre("Stairway to Heaven"));
        
        System.out.println(db.getSongs("Classical"));
        System.out.println(db.getSongs("Country"));
        System.out.println(db.getGenre("Ring of Fire"));
        System.out.println(db.getGenre("Moonlight Sonata"));
    }
}
