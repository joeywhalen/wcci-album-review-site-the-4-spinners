package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
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

    //GET http://localhost:8080/api/lists
    @GetMapping("/api/lists")
    public Iterable<List> retrieveAllList() {
        return listStorage.retrieveAllList();
    }

    //GET http://localhost:8080/api/lists/1
    @GetMapping("/api/lists/{id}")
    public List retrieveListById(@PathVariable Long id) {
        return listStorage.retrieveListById(id);
    }

    //DELETE http://localhost:8080/api/lists/1
    @DeleteMapping("/api/lists/{id}")
    public Iterable<List> deleteListById(@PathVariable Long id) {
        listStorage.deleteListById(id);
        return listStorage.retrieveAllList();
    }

    //POST http://localhost:8080/api/lists
    //Content-Type: application/json

    //{"listName": "BobList"}
    @PostMapping("/api/lists")
    public Iterable<List> addNewList(@RequestBody List listToAdd) {
        listStorage.saveList(listToAdd);
        return listStorage.retrieveAllList();
    }

    //PUT http://localhost:8080/api/lists
    //Content-Type: application/json
    //{"id":1, "listName": "MaynardList"}
    @PutMapping("/api/lists")
    public Iterable<List> modifyList(@RequestBody List listToModify) {
        if (listToModify.getId()!=null) {
            listStorage.saveList(listToModify);
        }
        return listStorage.retrieveAllList();
    }

}
