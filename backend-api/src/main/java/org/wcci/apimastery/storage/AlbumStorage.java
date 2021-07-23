package org.wcci.apimastery.storage;

import org.wcci.apimastery.resources.Album;
import org.springframework.stereotype.Service;

@Service
public class AlbumStorage {
    private AlbumRepository albumRepository;

    public AlbumStorage(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }

    public Album retrieveAlbumById(Long id){
        return albumRepository.findById(id).get();
    }

    public Iterable<Album> retrieveAllAlbums(){
        return albumRepository.findAll();
    }

    public void saveAlbum(Album albumToSave){
        albumRepository.save(albumToSave);
    }

    public void deleteAlbumById(Long id){
        albumRepository.deleteById(id);
    }
}
