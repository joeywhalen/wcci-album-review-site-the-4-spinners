package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.storage.AlbumRepository;
import org.wcci.apimastery.storage.ListStorage;
import org.wcci.apimastery.storage.SongRepository;

@RestController
public class ListController {

    private ListStorage listStorage;
    private AlbumRepository albumRepository;
    private SongRepository songongRepository;

    public ListController(ListStorage listStorage, AlbumRepository albumRepository, SongRepository songongRepository) {
        this.listStorage = listStorage;
        this.albumRepository = albumRepository;
        this.songongRepository = songongRepository;
    }


}
