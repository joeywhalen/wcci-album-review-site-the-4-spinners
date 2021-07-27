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
                 "Record label", "90", 5,"video.com");
         albumStorage.saveAlbum(album1);
         Song song1 = new Song(album1,"sing song", "90", 5);
         songStorage.saveSong(song1);
         Song song2 = new Song(album1,"Blah blah", "45", 4);
         songStorage.saveSong(song2);

         List jawList = new List("jaw List");
         listStorage.saveList(jawList);

         Album laSex = new Album(jawList, "La Sexorcisto: Devil Music Volume One", "White Zombie",
                 "https://upload.wikimedia.org/wikipedia/en/thumb/2/21/White_Zombie_La_Sexorcisto_Devil_Music%2C_Vol._1.jpg/220px-White_Zombie_La_Sexorcisto_Devil_Music%2C_Vol._1.jpg",
                  "Geffen", "57m 30s", 5,
                 "https://www.youtube.com/embed/H8gHMU-pDbU",
                 "The 'debut' album from White Zombie is pure unadulterated horror movie schlock in the best sense.  No filler, each song flowing into the next.  Wet, hot, summer fun.");
         albumStorage.saveAlbum(laSex);

         Song welcomeToPlanet = new Song(laSex,"Welcome to Planet Motherfucker/Psychoholic Slag",
                 "6m 21s", 5,
                 "If this song doesn’t get you moving, you probably don’t have a pulse.  Favorite Lyric: So let me see ya howl'n through the keyhole\"god damn,\n" +
                         "Swept away\" she shouted, she love it, getin away yeah!");
        songStorage.saveSong(welcomeToPlanet);

        Song knuckleDuster = new Song(laSex,"Knuckle Duster (Radio 1-A)", "0m 21s", 2);
        songStorage.saveSong(knuckleDuster);

        Song thunderKiss = new Song(laSex,"Thunder Kiss '65", "3m 54s", 5);
        songStorage.saveSong(thunderKiss);

        Song blackSun = new Song(laSex,"Black Sunshine (featuring Iggy Pop)", "4m 49s", 5);
        songStorage.saveSong(blackSun);

        Song soulCrusher = new Song(laSex,"Soul-Crusher (featuring Iggy Pop)", "5m 7s", 5);
        songStorage.saveSong(soulCrusher);

        Song cosmicMon = new Song(laSex,"Cosmic Monsters Inc.", "5m 13s", 4);
        songStorage.saveSong(cosmicMon);

        Song spiderbaby = new Song(laSex,"Spiderbaby (Yeah-Yeah-Yeah)", "5m 1s", 4);
        songStorage.saveSong(spiderbaby);

        Song legend = new Song(laSex,"I Am Legend", "5m 8s", 5);
        songStorage.saveSong(legend);

        Song knuckleDuster2 = new Song(laSex,"Knuckle Duster (Radio 2-B)", "0m 25s", 2);
        songStorage.saveSong(knuckleDuster2);

        Song thrust = new Song(laSex, "Thrust!", "5m 4s", 4);
        songStorage.saveSong(thrust);

        Song oneBig = new Song(laSex, "One Big Crunch", "0m 21s", 2);
        songStorage.saveSong(oneBig);

        Song grindhouse = new Song(laSex, "Grindhouse (A Go-Go)", "4m 5s", 4);
        songStorage.saveSong(grindhouse);

        Song starface = new Song(laSex, "Starface", "5m 2s", 4);
        songStorage.saveSong(starface);

        Song warpAsylum = new Song(laSex, "Warp Asylum", "6m 44s", 5);
        songStorage.saveSong(warpAsylum);


         Album nail = new Album(jawList,"Nail", "Foetus",
                 "https://upload.wikimedia.org/wikipedia/en/b/b5/Foetus_Nail.jpg",
                  "Self Immolation/Some Bizzare", "40m 4s", 5,
                 "https://www.youtube.com/embed/OnY63APl_6c",
                 "J.G. Thirlwell is a lyrical genius and this is his masterpiece.  One of the pioneers of the ‘industrial’ sound, and some classical overtures thrown in for good measure.  References run the gamut from Hamlet to Timothy Leary, to the Manson murders, to Jack and the Beanstalk.");
         albumStorage.saveAlbum(nail);

         Song themePigdom = new Song(nail, "Theme from Pigdom Come", "1m 52s", 5);
         songStorage.saveSong(themePigdom);

         Song throneAgony = new Song(nail, "The Throne of Agony", "5m 18s", 5);
         songStorage.saveSong(throneAgony);

         Song exclamation = new Song(nail, "!", "0m 4s", 4);
         songStorage.saveSong(exclamation);

         Song descentInferno = new Song(nail, "Descent into the Inferno", "6m 17s", 5);
         songStorage.saveSong(descentInferno);

         Song enterExterminator = new Song(nail, "Enter the Exterminator", "4m 43s", 5);
         songStorage.saveSong(enterExterminator);

         Song di19026 = new Song(nail, "DI-1-9026", "4m 40s", 5);
         songStorage.saveSong(di19026);

         Song overturePigdom = new Song(nail, "The Overture from Pigdom Come", "3m 1s", 5);
         songStorage.saveSong(overturePigdom);

         Song privateWar = new Song(nail, "Private War", "1m 6s", 5);
         songStorage.saveSong(privateWar);

         Song anythingViva = new Song(nail, "Anything (Viva!)", "6m 50s", 5,
                 "The last three songs really combine to form one killer ‘get my ass fired up!’ anthem that should be required in every half time locker room speech.  Favorite Lyric: C’mon, man.  The ENTIRE song!");
         songStorage.saveSong(anythingViva);


         Album extremities = new Album(jawList,"Extremities, Dirt and Various Repressed Emotions", "Killing Joke",
                 "https://upload.wikimedia.org/wikipedia/en/thumb/d/d2/Killing_scene_Extremeties_Dirt_%26_Various_Repressed_Emotions.jpg/220px-Killing_scene_Extremeties_Dirt_%26_Various_Repressed_Emotions.jpg",
                  "Noise", "1h 5m 8s", 5,
                 "https://www.youtube.com/embed/dCs0D6AJUuM",
                 "Quite the departure from their previous album “Outside the Gate” as Martin Atkins (PIL, Pigface) joins the band for a ‘one and done’ on drums.  This one turns it ‘up to 11’ with not only the power of the sound, but the lyrics as well.  So thankful to have seen them on tour at Bogarts in Cincy supporting this album.  Good times.");
         albumStorage.saveAlbum(extremities);

         Song moneyGod = new Song(extremities, "Money Is Not Our God", "5m 17s", 5);
         songStorage.saveSong(moneyGod);

         Song ageGreed = new Song(extremities, "Age of Greed", "7m 23s", 5,
                 "Great lyrics with great energy behind them.  If this song does not make you angry, you may not have a pulse.  Favorite Lyric: Your money, my time\n" +
                         "Your stinking industrial bathwater, my wine\n" +
                         "Imbalance induces hate\n" +
                         "How will you bridge the gap\n" +
                         "Between the endless buffet\n" +
                         "And the empty plate I have.");
         songStorage.saveSong(ageGreed);

         Song beautifulDead = new Song(extremities, "The Beautiful Dead", "6m 2s", 5);
         songStorage.saveSong(beautifulDead);

         Song extremitites = new Song(extremities, "Extremities", "5m 20s", 5);
         songStorage.saveSong(extremitites);

         Song intraveneous = new Song(extremities, "Intravenous", "7m 2s", 5);
         songStorage.saveSong(intraveneous);

         Song insideTermite = new Song(extremities, "Inside the Termite Mound", "7m 49s", 5);
         songStorage.saveSong(insideTermite);

         Song solitude = new Song(extremities, "Solitude", "5m 2s", 5);
         songStorage.saveSong(solitude);

         Song northBorder = new Song(extremities, "North of the Border", "5m 52s", 5);
         songStorage.saveSong(northBorder);

         Song slipstream = new Song(extremities, "Slipstream", "7m 7s", 5);
         songStorage.saveSong(slipstream);

         Song kaliyuga = new Song(extremities, "Kaliyuga", "2m 8s", 5);
         songStorage.saveSong(kaliyuga);

         Song struggle = new Song(extremities, "Struggle", "6m 13s", 5);
         songStorage.saveSong(struggle);


         Album killers = new Album(jawList,"Killers", "Iron Maiden",
                 "https://upload.wikimedia.org/wikipedia/en/thumb/b/b4/Iron_Maiden_Killers.jpg/220px-Iron_Maiden_Killers.jpg",
                  "EMI", "38m 18s", 5,
                 "https://www.youtube.com/embed/QUsibOlkt-o",
                 "When this album was released in 1981, I had no idea who Iron Maiden were, but Eddie on the cover and my friend telling me he thought that it might be ‘devil music’ sold me.  It was the hardest, fastest rock I had heard to that point, and an instant classic.  Bruce Dickinson famously joined the band on vocals after this album and they soared in popularity, but this is easily my favorite.  Another album where each song bleeds into the next.");
         albumStorage.saveAlbum(killers);

         Song idesOfMarch = new Song(killers, "The Ides of March (instrumental)", "1m 48s", 5);
         songStorage.saveSong(idesOfMarch);

         Song wrathchild = new Song(killers, "Wrathchild", "2m 54s", 5);
         songStorage.saveSong(wrathchild);

         Song rueMorgue = new Song(killers, "Murders in the Rue Morgue", "4m 14s", 5);
         songStorage.saveSong(rueMorgue);

         Song anotherLife = new Song(killers, "Another Life", "3m 22s", 5);
         songStorage.saveSong(anotherLife);

         Song genghisKhan = new Song(killers, "Genghis Khan (instrumental)", "3m 2s", 5);
         songStorage.saveSong(genghisKhan);

         Song innocentExile = new Song(killers, "Innocent Exile", "3m 50s", 5);
         songStorage.saveSong(innocentExile);

         Song killersSong = new Song(killers, "Killers", "4m 58s", 5);
         songStorage.saveSong(killersSong);

         Song prodigalSon = new Song(killers, "Prodigal Son", "6m 5s", 5,
                 "Beautiful and haunting.  Such a shame that the band doesn’t appear to agree as I don’t believe they have ever played it on tour.  Favorite Lyric: Oh Lamia, please, try to help me\n" +
                         "The devil's got a hold of my soul and he won't let me be\n" +
                         "Lamia, I've got this curse, I'm turning to bad\n" +
                         "The devil's got a hold of my soul, he's driving me mad.");
         songStorage.saveSong(prodigalSon);

         Song purgatory = new Song(killers, "Purgatory", "3m 18s", 5);
         songStorage.saveSong(purgatory);

         Song drifter = new Song(killers, "Drifter", "4m 47s", 5);
         songStorage.saveSong(drifter);

         Album undertow = new Album(jawList,"Undertow", "Tool",
                 "https://upload.wikimedia.org/wikipedia/en/thumb/8/82/Tool-Undertow.jpg/220px-Tool-Undertow.jpg",
                  "Zoo", "1h 9m 13s", 5,
                 "https://www.youtube.com/embed/I8yoVlkLERs",
                 "Just perfection from the lyrics to the vocals and the full, raw power of the instruments.  Could listen to this on an endless loop, stopping only to occasionally skip Sober as it was a bit overplayed.  This album sold me on all things Maynard.");
         albumStorage.saveAlbum(undertow);

         Song intolerance = new Song(undertow, "Intolerance", "4m 53s", 5);
         songStorage.saveSong(intolerance);

         Song prisonSex = new Song(undertow, "Prison Sex", "4m 56s", 5);
         songStorage.saveSong(prisonSex);

         Song sober = new Song(undertow, "Sober", "5m 6s", 4);
         songStorage.saveSong(sober);

         Song bottom = new Song(undertow, "Bottom", "7m 14s", 5);
         songStorage.saveSong(bottom);

         Song crawlAway = new Song(undertow, "Crawl Away", "5m 30s", 5);
         songStorage.saveSong(crawlAway);

         Song swampSong = new Song(undertow, "Swamp Song", "5m 31s", 5,
                 "If your neck does not need a brace after listening to this song, you may not have a pulse.");
         songStorage.saveSong(swampSong);

         Song undertowSong = new Song(undertow, "Undertow", "5m 22s", 5);
         songStorage.saveSong(undertowSong);

         Song fourDegrees = new Song(undertow, "4°", "6m 3s", 5,
                 " Favorite Lyric: Locked up inside you\n" +
                         "Like the calm beneath castles\n" +
                         "Is a cavern of treasures that\n" +
                         "Noone has been to\n" +
                         "Let's go digging.");
         songStorage.saveSong(fourDegrees);

         Song flood = new Song(undertow, "Flood", "7m 46s", 5);
         songStorage.saveSong(flood);

         Song disgustipated = new Song(undertow, "Disgustipated", "15m 47s", 5,
                 "Favorite Lyric: Let the rabbits wear glasses");
         songStorage.saveSong(disgustipated);


         List naList = new List("nana List");
         listStorage.saveList(naList);

         Album inASilentWay = new Album(naList,"In A Silent Way ","Miles Davis","https://www.bluescentric.com/images/product/large/4310.jpg","Columbia Records","38m 09s", 5, "https://www.youtube.com/watch?v=YHesqaMhh34","Miles Davies gave us a mighty touch with his 'In A Silent Way' album, It is a musical rebirth, a sense of motherly warmth takes over, and then we hear, yet again, Davis’ cosmic trumpet playing which concludes the album with a calming fade.");
         albumStorage.saveAlbum(inASilentWay);

         Song shhPeaceful = new Song(inASilentWay,"Shhh / Peacefull","18m 30s",5,"This jam will have you tip-toeing around your house, very relaxing yet stimulating");
         songStorage.saveSong(shhPeaceful);

         Song aboutThatTime = new Song(inASilentWay,"In A Silent /It's About That Time","20m 0s",5,"One of the smoothest jams on earth, This is a must listen for any jazz fans out there who wish to transcend into a groove");
         songStorage.saveSong(aboutThatTime);


         Album zombie = new Album(naList,"Zombie","Fela Kuti", "https://is2-ssl.mzstatic.com/image/thumb/Music125/v4/64/02/1c/64021cbe-25b4-a38b-4495-88578359ca19/720841206194.jpg/270x270bb.webp","COCONUT","25m 41s",4,"https://www.youtube.com/watch?v=-3j0nugz1Pw&list=OLAK5uy_n4UDREKrRXJxqya81gWWhXN_5ImgFWtNM","Fela Kuti, a Nigerian Afrobeat and political activist released 'Zombie' in 1976 which has been one of his most political musical statement.");
         albumStorage.saveAlbum(zombie);

         Song mrFollowFollow = new Song(zombie,"Mr. Follow Follow","12m 58s",5,"'Mr. Follow Follow' has a deeper commentary and a clearer theme about conformity as it relates to the military and the state. ");
         songStorage.saveSong(mrFollowFollow);

         Song observationIsNoCrime = new Song(zombie,"Observation Is No Crime","13m 26s",5);
         songStorage.saveSong(observationIsNoCrime);

         Song mistake = new Song(zombie,"Mistake (Live at the Berlin Jazz Festival, 1978)","14m 47s",5);
         songStorage.saveSong(mistake);

         Song zombieo = new Song(zombie,"zombie", "12m 26s",5);
         songStorage.saveSong(zombieo);


         Album conflict = new Album(naList,"Conflict","Ebo Taylor & Uhuru Yenzu","https://f4.bcbits.com/img/a2585325512_16.jpg","Mr. Bongo","31m 19s",4,"https://www.youtube.com/watch?v=Q54D5EVtRsQ","The album is both, mesmerizing and beautiful, and stands up well to many of the other monumental releases by Ebo Taylor. This album shows Ebo Taylor’s trademark approach that saw him inject a heavy dose of funk into Ghanaian traditional highlife grooves in an attempt to move away from what he saw as the music’s more traditional qualities.");
         albumStorage.saveAlbum(conflict);

         Song youNeedLove = new Song(conflict,"You Need Love", "07m 09s",5, "A classic");
         songStorage.saveSong(youNeedLove);

         Song loveAndDeath = new Song(conflict,"Love And Death","08m 19s",4);
         songStorage.saveSong(loveAndDeath);

         Song whatIsLife = new Song(conflict,"What Is Life","04m 37s",4);
         songStorage.saveSong(whatIsLife);

         Song christWillCome = new Song(conflict,"Christ Will Come","06m 58s",4);
         songStorage.saveSong(christWillCome);

         Song victory = new Song(conflict,"Victory","04m 16s",4);
         songStorage.saveSong(victory);

        

         List harrisonList = new List("harrison List");
         listStorage.saveList(harrisonList);

         Album foodAndLiquor = new Album(harrisonList,"Lupe Fiasco's Food & Liquor ","Lupe Fiasco","https://images-na.ssl-images-amazon.com/images/I/81B4l7WTz3L._SL1453_.jpg","Atlantic Records","72m 13s", 4, "https://www.youtube.com/watch?v=Gl83mI69nX4","blah blah blah");
         albumStorage.saveAlbum(foodAndLiquor);

         Song intro = new Song(foodAndLiquor,"Intro","3m 7s",5,"tbd");
         songStorage.saveSong(intro);

         Song real = new Song(foodAndLiquor,"Real (featuring Sarah Green)","4m 2s",4,"tbd");
         songStorage.saveSong(real);

         Song justMightBeOK = new Song(foodAndLiquor,"Just Might Be OK (featuring Gemini)","4m 24s",5,"tbd");
         songStorage.saveSong(justMightBeOK);

         Song kickPush = new Song(foodAndLiquor,"Kick, Push","4m 13s",5,"tbd");
         songStorage.saveSong(kickPush);

         Song iGotcha = new Song(foodAndLiquor,"I Gotcha","3m 59s",5,"tbd");
         songStorage.saveSong(iGotcha);

         Song heSaySheSay = new Song(foodAndLiquor,"He Say She Say","4m 12s",5,"tbd");
         songStorage.saveSong(heSaySheSay);

         Song sunshine = new Song(foodAndLiquor,"Sunshine","3m 55s",5,"tbd");
         songStorage.saveSong(sunshine);

         Song daydreamin = new Song(foodAndLiquor,"Daydreamin' (featuring Jill Scott)","3m 55s",5,"tbd");
         songStorage.saveSong(daydreamin);         

         Song theCool = new Song(foodAndLiquor,"The Cool","3m 46s",5,"tbd");
         songStorage.saveSong(theCool);

         Song hurtMeSoul = new Song(foodAndLiquor,"Hurt Me Soul","4m 22s",5,"tbd");
         songStorage.saveSong(hurtMeSoul);

         Song pressure = new Song(foodAndLiquor,"Pressure (featuring Jay-Z)","4m 47s",3,"tbd");
         songStorage.saveSong(pressure);

         Song americanTerrorist = new Song(foodAndLiquor,"American Terrorist (featuring Matthew Santos)","4m 40s",5,"tbd");
         songStorage.saveSong(americanTerrorist);

         Song theEmperorsSoundtrack = new Song(foodAndLiquor,"The Emperor's Soundtrack","2m 56s",3,"tbd");
         songStorage.saveSong(theEmperorsSoundtrack);

         Song kickPush2 = new Song(foodAndLiquor,"Kick, Push II","4m 11s",5,"tbd");
         songStorage.saveSong(kickPush2);

         Song outro = new Song(foodAndLiquor,"Outro","12m 13s",5,"tbd");
         songStorage.saveSong(outro);


         Album rapture = new Album(harrisonList,"Rapture","Anita Baker", "https://images-na.ssl-images-amazon.com/images/I/71bd2KuN3lL._SL1425_.jpg","Elektra","37m 9s",5,"https://www.youtube.com/watch?v=QlhZPNv7f8Q","tbd.");
         albumStorage.saveAlbum(rapture);

         Song sweetLove = new Song(rapture,"Sweet Love","4m 26s",5,"tbd");
         songStorage.saveSong(sweetLove);

         Song youBringMeJoy = new Song(rapture,"You Bring Me Joy","4m 24s",5,"tbd");
         songStorage.saveSong(youBringMeJoy);

         Song caughtUpInTheRapture = new Song(rapture,"Caught Up In The Rapture","5m 17s",5,"tbd");
         songStorage.saveSong(caughtUpInTheRapture);

         Song beenSoLong = new Song(rapture,"Been So Long","5m 7s",4,"tbd");
         songStorage.saveSong(beenSoLong);

         Song mystery = new Song(rapture,"Mystery","4m 56s",5,"tbd");
         songStorage.saveSong(mystery);

         Song noOneInTheWorld = new Song(rapture,"No One In The World","4m 10s",5,"tbd");
         songStorage.saveSong(noOneInTheWorld);

         Song sameOleLove = new Song(rapture,"Same Ole Love (365 Days a Year)","4m 5s",4,"tbd");
         songStorage.saveSong(sameOleLove);

         Song watchYourStep = new Song(rapture,"Watch Your Step","4m 54s",4,"tbd");
         songStorage.saveSong(watchYourStep);


    }
}