package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.resources.Album;
import org.wcci.apimastery.resources.List;
import org.wcci.apimastery.resources.Song;
import org.wcci.apimastery.storage.*;

@RestController
public class ListController {

    private ListStorage listStorage;
    private AlbumRepository albumRepository;
    private SongRepository songRepository;

    public ListController(ListStorage listStorage, AlbumRepository albumRepository, SongRepository songRepository) {
        this.listStorage = listStorage;
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
    }

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

    //Update a list's name property.
    //PATCH http://localhost:8080/api/lists/1/listName
    //Maynard's List
    @PatchMapping("/api/lists/{id}/listName")
    public List changeListName(@PathVariable Long id, @RequestBody String listName) {
        List listToChange = listStorage.retrieveListById(id);
        listToChange.changeListName(listName);
        listStorage.saveList(listToChange);
        return listToChange;
    }

    // ### List albums of a list
    // GET http://localhost:8080/api/lists/1/albums
    // Content-Type: application/json
    @GetMapping("/api/lists/{id}/albums")
    public Iterable<Album> retrieveAllAlbumsInList(@PathVariable Long id) {
        return listStorage.retrieveListById(id).getAlbums();
    }

    // ### Display single ablbum of a list
    // GET http://localhost:8080/api/lists/5/albums/6
    @GetMapping("/api/lists/{id}/albums/{albumId}")
    public Album retrieveAlbumById(@PathVariable Long id, @PathVariable Long albumId) {
        return albumRepository.findById(albumId).get();
    }

    //     ### Update Albums name property
    // PATCH http://localhost:8080/api/lists/5/albums/6/albumName
    @PatchMapping("/api/lists/{id}/albums/{albumId}/albumName")
    public Album changeAlbumName(@PathVariable Long id, @PathVariable Long albumId, @RequestBody String albumTitle){
        Album albumToChange = albumRepository.findById(albumId).get();
        albumToChange.changeAlbumTitle(albumTitle);
        albumRepository.save(albumToChange);
        return albumToChange;
    }

    //### Add a new album resource to the list's albums.
    //PATCH http://localhost:8080/api/lists/1/albums
    //Content-Type: application/json
    //{"title": "New Album","artist": "Sample Artist","imageURL": "Sample image URL","recordLabel": "Sample Record Label","duration": "Sample duration","rating": 5,"videoUrl": "Sample video URL","comments": "Sample commenrs"}
    @PostMapping("/api/lists/{id}/albums")
    public List addAlbumToList(@PathVariable Long id, @RequestBody Album albumToAdd) {
        List listToChange = listStorage.retrieveListById(id);

        listToChange.addAlbum(albumToAdd);
        listStorage.saveList(listToChange);
        albumToAdd.changeList(listToChange);
        albumRepository.save(albumToAdd);

        if (albumToAdd.hasSongs()) {
            for (Song song : albumToAdd.getSongs()) {
                song.addAlbum(albumToAdd);
                songRepository.save(song);
                albumRepository.save(albumToAdd);
            }
        }
        return listToChange;
    }
    
    // ### Add comment to album
    // PATCH http://localhost:8080/api/lists/1/albums/6/comments
    // Content-Type: application/json
    @PatchMapping("/api/lists/{id}/albums/{albumId}/comments")
    public Album addAlbumComment(@PathVariable Long id, @PathVariable Long albumId, @RequestBody String newComment) {
        Album albumToChange = albumRepository.findById(albumId).get();

        albumToChange.addComment(newComment);
        albumRepository.save(albumToChange);
        return albumToChange;
    }

    //### Delete an album with id from a list.
    //DELETE http://localhost:8080/api/lists/1/albums/2
    @DeleteMapping("/api/lists/{id}/albums/{albumId}")
    public List deleteAlbumFromList(@PathVariable Long id, @PathVariable Long albumId) {
        List listToChange = listStorage.retrieveListById(id);
        Album album = albumRepository.findById(albumId).get();
        listToChange.removeAlbum(album);
        albumRepository.deleteById(albumId);
        listStorage.saveList(listToChange);
        return listToChange;
    }

    // ### List songs of a specific album
    // GET http://localhost:8080/api/lists/5/albums/6/songs
    // Content-Type: application/json
    @GetMapping("/api/lists/{id}/albums/{albumId}/songs")
    public Iterable<Song> retrieveAllSongsInAlbums(@PathVariable Long id, @PathVariable Long albumId) {
        return listStorage.retrieveAlbumById(albumId).getSongs();
    }

    // ### Display single song of a specific album 
    // GET http:// localhost:8080/api/lists/5/albums/6/songs/7
    // Content-Type:application/json
    @GetMapping("/api/lists/{id}/albums/{albumId}/songs/{songId}")
    public Song retrieveSongById(@PathVariable Long id, @PathVariable Long albumId, @PathVariable Long songId) {
        return songRepository.findById(songId).get();
    }

    //     ### Add new song to specific album
    // PATCH http://localhost:8080/api/lists/5/albums/6/songs
    // Content-Type: application/json
    @PatchMapping("/api/lists/{id}/albums/{albumId}/songs")
    public Album addSongToAlbum(@PathVariable Long id, @PathVariable Long albumId, @RequestBody Song songToAdd) {
        Album albumToChange = listStorage.retrieveAlbumById(albumId);
        songRepository.save(songToAdd);
        songToAdd.addAlbum(albumToChange);
        albumToChange.addSong(songToAdd);
        albumRepository.save(albumToChange);
        return albumToChange;
    }

    //     ### Delete a Song off a specific album
    // DELETE http://localhost:8080/api/lists/5/albums/6/songs
    @DeleteMapping("/api/lists/{id}/albums/{albumId}/songs/{songId}")
    public Album deleteSongFromAlbum(@PathVariable Long id, @PathVariable Long albumId, @PathVariable Long songId) {
        Album albumToChange = listStorage.retrieveAlbumById(albumId);
        Song song = songRepository.findById(songId).get();
        albumToChange.removeSong(song);
        return albumToChange;
    }

    //     ### Change Song Title
    // PATCH http://localhost:8080/api/lists/5/albums/6/songs/7/songTitle
    @PatchMapping("/api/lists/{id}/albums/{albumId}/songs/{songId}/songTitle")
    public Song changeSongTitle(@PathVariable Long id, @PathVariable Long albumId, @PathVariable Long songId, @RequestBody String newSongTitle){
        Song songToChange = songRepository.findById(songId).get();
        songToChange.changeSongTitle(newSongTitle);
        songRepository.save(songToChange);
        return songToChange;
    }

    //     ### Add comment to song
    // POST http://localhost:8080/api/lists/1/albums/6/songs/7/comments
    // Content-Type: application/json

    @PatchMapping("/api/lists/{id}/albums/{albumId}/songs/{songId}/comments")
    public Song addSongComment(@PathVariable Long id, @PathVariable Long albumId, @PathVariable Long songId, @RequestBody String newComment){
        Song songToChange = songRepository.findById(songId).get();
        
        songToChange.addSongComment(newComment);
        songRepository.save(songToChange);
        return songToChange;
    }


}
