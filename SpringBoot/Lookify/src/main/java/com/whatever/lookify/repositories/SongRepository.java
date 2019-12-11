package com.whatever.lookify.repositories;

import java.util.List;

import com.whatever.lookify.models.Song;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * SongRepository
 */
@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
    List<Song> findAll();
    // this method finds languages with descriptions containing the search string
}