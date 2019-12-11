package com.whatever.lookify.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.whatever.lookify.models.Song;
import com.whatever.lookify.repositories.SongRepository;

import org.springframework.stereotype.Service;

/**
 * SongService
 */
@Service
public class SongService {

    private final SongRepository songRepository;
// The below constructor must match the classname!!!
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    // returns all the songs
    public List<Song> allSongs() {
        return songRepository.findAll();
    }

    // creates a song
    public Song createSong(Song b) {
        return songRepository.save(b);
    }

    // retrieves a song
    public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }

    public ArrayList<Song> findSongByArtist(String artist) {
        List<Song> theSongs = songRepository.findAll();
        ArrayList<Song> newList = new ArrayList<Song>();
        for(Song song : theSongs){
            if(song.getArtist().contains(artist)){
                newList.add(song);
            }
        }
        return newList;
    }
    
    // public Song updateSongcopy(long id, String title, String artist, int rating) {
    // 	Song song = findSong(id);
    // 	song.setTitle(title);
    // 	song.setArtist(artist);
    // 	song.setRating(rating);
    // 	Song song2 = songRepository.save(song);
    // 	return song2;
    // }
    
    public void deleteSong(long id) {
    	songRepository.deleteById(id);
    }
}