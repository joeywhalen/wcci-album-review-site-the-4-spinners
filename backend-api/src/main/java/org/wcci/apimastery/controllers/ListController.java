package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.resources.List;
import org.wcci.apimastery.storage.*;

@RestController
public class ListController {

    private ListStorage listStorage;
//    private AlbumStorage albumStorage;
//    private SongStorage songStorage;
//    private AlbumRepository albumRepository;
//    private SongRepository songRepository;

    public ListController(ListStorage listStorage) {
        this.listStorage = listStorage;
    }


//    public ListController(ListStorage listStorage, AlbumRepository albumRepository, SongRepository songRepository) {
//        this.listStorage = listStorage;
//        this.albumRepository = albumRepository;
//        this.songRepository = songRepository;
//    }

//    public ListController(ListStorage listStorage, AlbumStorage albumStorage, SongStorage songStorage) {
//        this.listStorage = listStorage;
//        this.albumStorage = albumStorage;
//        this.songStorage = songStorage;
//    }


//    public ListController(ListStorage listStorage) {
//
//    }

    //GET localhost:8080/api/lists
    @GetMapping("/api/lists")
    public Iterable<List> retrieveAllList() {
        return listStorage.retrieveAllList();
    }

    //GET localhost:8080/api/lists/1
    @GetMapping
    public List retrieveListById(@PathVariable Long id) {
        return listStorage.retrieveListById(id);
    }



}
