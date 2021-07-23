package org.wcci.apimastery;


import org.resources.Album;
import org.resources.List;
import org.resources.Song;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.storage.AlbumStorage;
import org.storage.ListStorage;
import org.storage.SongStorage;

@Component
public class Populator implements CommandLineRunner {
    private ListStorage listStorage;
    private AlbumStorage albumStorage;
    private SongStorage songStorage;

    public Populator(ListStorage listStorage, AlbumStorage albumStorage, SongStorage songStorage){
        this.listStorage = listStorage;
        this.albumStorage = albumStorage;
        this.songStorage = songStorage;
    }

    @Override
    public void run(String... args) throws Exception{
        List list1 = new List("joe's list");
        listStorage.saveList(list1);
        Album album1 = new Album("Album title","Artist", "WWW.com","Song title","Record label", 90, 5,"video.com");
        albumStorage.saveAlbum((album1));
        Song song1 = new Song("sing song", 90, 5);
        songStorage.saveSong((song1));
        Song song2 = new Song("Blah blah", 45, 4);
    }
    
}

