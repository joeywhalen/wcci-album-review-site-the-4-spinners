package org.wcci.apimastery.storage;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.resources.Album;
import org.wcci.apimastery.resources.List;


@Service
public class ListStorage {
    private ListRepository listRepository;
    private AlbumRepository albumRepository;

    public ListStorage(ListRepository listRepository, AlbumRepository albumRepository){
        this.listRepository = listRepository;
        this.albumRepository = albumRepository;
    }

    public List retrieveListById(Long id){
        return listRepository.findById(id).get();
    }

    public void saveList(List listToSave){
        listRepository.save(listToSave);
    }

    public Iterable<List> retrieveAllList(){
        return listRepository.findAll();
    }

    public void deleteListById(Long id){
        listRepository.deleteById(id);
    }
    public Album retrieveAlbumById(Long id){
        return albumRepository.findById(id).get();
    }
}
