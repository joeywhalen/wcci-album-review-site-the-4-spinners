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
         Album album1 = new Album(list1,"Album title","Artist", "WWW.com",
                 "Song title","Record label", "90", 5,"video.com");
         albumStorage.saveAlbum(album1);
         Song song1 = new Song("sing song", "90", 5);
         songStorage.saveSong(song1);
         Song song2 = new Song("Blah blah", "45", 4);
         songStorage.saveSong(song2);

         List jawList = new List("jaw List");
         listStorage.saveList(jawList);

         Album laSex = new Album(jawList, "La Sexorcisto: Devil Music Volume One", "White Zombie",
                 "https://upload.wikimedia.org/wikipedia/en/thumb/2/21/White_Zombie_La_Sexorcisto_Devil_Music%2C_Vol._1.jpg/220px-White_Zombie_La_Sexorcisto_Devil_Music%2C_Vol._1.jpg",
                 "Song", "Geffen", "57m 30s", 5,
                 "https://www.youtube.com/embed/H8gHMU-pDbU",
                 "The 'debut' album from White Zombie is pure unadulterated horror movie schlock in the best sense.  No filler, each song flowing into the next.  Wet, hot, summer fun.");
         albumStorage.saveAlbum(laSex);

         Album nail = new Album(jawList,"Nail", "Foetus",
                 "https://upload.wikimedia.org/wikipedia/en/b/b5/Foetus_Nail.jpg",
                 "Song", "Self Immolation/Some Bizzare", "40m 4s", 5,
                 "https://www.youtube.com/embed/OnY63APl_6c",
                 "J.G. Thirlwell is a lyrical genius and this is his masterpiece.  One of the pioneers of the ‘industrial’ sound, and some classical overtures thrown in for good measure.  References run the gamut from Hamlet to Timothy Leary, to the Manson murders, to Jack and the Beanstalk.");
         albumStorage.saveAlbum(nail);

         Album extremities = new Album(jawList,"Extremities, Dirt and Various Repressed Emotions", "Killing Joke",
                 "https://upload.wikimedia.org/wikipedia/en/thumb/d/d2/Killing_scene_Extremeties_Dirt_%26_Various_Repressed_Emotions.jpg/220px-Killing_scene_Extremeties_Dirt_%26_Various_Repressed_Emotions.jpg",
                 "Song", "Noise", "1h 5m 8s", 5,
                 "https://www.youtube.com/embed/dCs0D6AJUuM",
                 "Quite the departure from their previous album “Outside the Gate” as Martin Atkins (PIL, Pigface) joins the band for a ‘one and done’ on drums.  This one turns it ‘up to 11’ with not only the power of the sound, but the lyrics as well.  So thankful to have seen them on tour at Bogarts in Cincy supporting this album.  Good times.");
         albumStorage.saveAlbum(extremities);

         Album killers = new Album(jawList,"Killers", "Iron Maiden",
                 "https://upload.wikimedia.org/wikipedia/en/thumb/b/b4/Iron_Maiden_Killers.jpg/220px-Iron_Maiden_Killers.jpg",
                 "Song", "EMI", "38m 18s", 5,
                 "https://www.youtube.com/embed/QUsibOlkt-o",
                 "When this album was released in 1981, I had no idea who Iron Maiden were, but Eddie on the cover and my friend telling me he thought that it might be ‘devil music’ sold me.  It was the hardest, fastest rock I had heard to that point, and an instant classic.  Bruce Dickinson famously joined the band on vocals after this album and they soared in popularity, but this is easily my favorite.  Another album where each song bleeds into the next.");
         albumStorage.saveAlbum(killers);

         Album undertow = new Album(jawList,"Undertow", "Tool",
                 "https://upload.wikimedia.org/wikipedia/en/thumb/8/82/Tool-Undertow.jpg/220px-Tool-Undertow.jpg",
                 "Song", "Zoo", "1h 9m 13s", 5,
                 "https://www.youtube.com/embed/I8yoVlkLERs",
                 "Just perfection from the lyrics to the vocals and the full, raw power of the instruments.  Could listen to this on an endless loop, stopping only to occasionally skip Sober as it was a bit overplayed.  This album sold me on all things Maynard.");
         albumStorage.saveAlbum(undertow);




    }
    
}

