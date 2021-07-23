package org.storage;

import org.springframework.stereotype.Service;
import org.resources.Song;

@Service
public class SongStorage {
    private SongRepository songRepo;

    public SongStorage(SongRepository songRepo) {
        this.songRepo = songRepo;
    }

    public Song retrieveSongById(Long id) {
        return songRepo.findById(id).get();

    }

    public Iterable<Song> retrieveAllSongs() {
        return songRepo.findAll();
    }

    public void saveSong(Song songToSave) {
        songRepo.save(songToSave);
    }

    public void deleteSongById(Long id) {
        songRepo.deleteById(id);
    }

}