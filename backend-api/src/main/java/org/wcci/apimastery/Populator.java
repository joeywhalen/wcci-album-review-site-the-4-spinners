package org.wcci.apimastery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.storage.*;
import org.wcci.apimastery.resources.*;

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
         Album album1 = new Album("Album title","Artist", "WWW.com",
                 "Song title","Record label", "90", 5,"video.com");
         albumStorage.saveAlbum(album1);
         Song song1 = new Song("sing song", "90", 5);
         songStorage.saveSong(song1);
         Song song2 = new Song("Blah blah", "45", 4);
         songStorage.saveSong(song2);

         List jawList = new List("jaw List");
         listStorage.saveList(jawList);

         Album laSex = new Album("La Sexorcisto: Devil Music Volume One", "White Zombie",
                 "https://upload.wikimedia.org/wikipedia/en/thumb/2/21/White_Zombie_La_Sexorcisto_Devil_Music%2C_Vol._1.jpg/220px-White_Zombie_La_Sexorcisto_Devil_Music%2C_Vol._1.jpg",
                 "Song", "Geffen", "57m 30s", 5,
                 "https://www.youtube.com/embed/H8gHMU-pDbU",
                 "The 'debut' album from White Zombie is pure unadulterated horror movie schlock in the best sense.  No filler, each song flowing into the next.  Wet, hot, summer fun.");
         albumStorage.saveAlbum(laSex);

         Album nail = new Album("Nail", "Foetus",
                 "https://upload.wikimedia.org/wikipedia/en/b/b5/Foetus_Nail.jpg",
                 "Song", "Self Immolation/Some Bizzare", "40m 4s", 5,
                 "https://www.youtube.com/embed/OnY63APl_6c",
                 "J.G. Thirlwell is a lyrical genius and this is his masterpiece.  One of the pioneers of the ‘industrial’ sound, and some classical overtures thrown in for good measure.  References run the gamut from Hamlet to Timothy Leary, to the Manson murders, to Jack and the Beanstalk.");
         albumStorage.saveAlbum(nail);

         


    }
    
}

