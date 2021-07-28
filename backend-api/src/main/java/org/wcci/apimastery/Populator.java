package org.wcci.apimastery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.storage.*;
import org.wcci.apimastery.resources.*;

@Component
public class Populator implements CommandLineRunner {
    private ListStorage listStorage;
    private AlbumRepository albumRepository;
    private SongRepository songRepository;

    public Populator(ListStorage listStorage, AlbumRepository albumRepository, SongRepository songRepository){
        this.listStorage = listStorage;
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
    }

    @Override
    public void run(String... args) throws Exception{
         List list1 = new List("joe's list");
         listStorage.saveList(list1);
         Album album1 = new Album(list1,"Album title","Artist", "WWW.com",
                 "Record label", "90", 5,"video.com");
         albumRepository.save(album1);
         Song song1 = new Song(album1,"sing song", "90", 5);
         songRepository.save(song1);
         Song song2 = new Song(album1,"Blah blah", "45", 4);
         songRepository.save(song2);

         List jawList = new List("jaw List");
         listStorage.saveList(jawList);

         Album laSex = new Album(jawList, "La Sexorcisto: Devil Music Volume One", "White Zombie",
                 "https://upload.wikimedia.org/wikipedia/en/thumb/2/21/White_Zombie_La_Sexorcisto_Devil_Music%2C_Vol._1.jpg/220px-White_Zombie_La_Sexorcisto_Devil_Music%2C_Vol._1.jpg",
                  "Geffen", "57m 30s", 5,
                 "https://www.youtube.com/embed/H8gHMU-pDbU",
                 "The 'debut' album from White Zombie is pure unadulterated horror movie schlock in the best sense.  No filler, each song flowing into the next.  Wet, hot, summer fun.");
         albumRepository.save(laSex);

         Song welcomeToPlanet = new Song(laSex,"Welcome to Planet Motherfucker/Psychoholic Slag",
                 "6m 21s", 5,
                 "If this song doesn’t get you moving, you probably don’t have a pulse.  Favorite Lyric: So let me see ya howl'n through the keyhole\"god damn,\n" +
                         "Swept away\" she shouted, she love it, getin away yeah!");
        songRepository.save(welcomeToPlanet);

        Song knuckleDuster = new Song(laSex,"Knuckle Duster (Radio 1-A)", "0m 21s", 2);
        songRepository.save(knuckleDuster);

        Song thunderKiss = new Song(laSex,"Thunder Kiss '65", "3m 54s", 5);
        songRepository.save(thunderKiss);

        Song blackSun = new Song(laSex,"Black Sunshine (featuring Iggy Pop)", "4m 49s", 5);
        songRepository.save(blackSun);

        Song soulCrusher = new Song(laSex,"Soul-Crusher (featuring Iggy Pop)", "5m 7s", 5);
        songRepository.save(soulCrusher);

        Song cosmicMon = new Song(laSex,"Cosmic Monsters Inc.", "5m 13s", 4);
        songRepository.save(cosmicMon);

        Song spiderbaby = new Song(laSex,"Spiderbaby (Yeah-Yeah-Yeah)", "5m 1s", 4);
        songRepository.save(spiderbaby);

        Song legend = new Song(laSex,"I Am Legend", "5m 8s", 5);
        songRepository.save(legend);

        Song knuckleDuster2 = new Song(laSex,"Knuckle Duster (Radio 2-B)", "0m 25s", 2);
        songRepository.save(knuckleDuster2);

        Song thrust = new Song(laSex, "Thrust!", "5m 4s", 4);
        songRepository.save(thrust);

        Song oneBig = new Song(laSex, "One Big Crunch", "0m 21s", 2);
        songRepository.save(oneBig);

        Song grindhouse = new Song(laSex, "Grindhouse (A Go-Go)", "4m 5s", 4);
        songRepository.save(grindhouse);

        Song starface = new Song(laSex, "Starface", "5m 2s", 4);
        songRepository.save(starface);

        Song warpAsylum = new Song(laSex, "Warp Asylum", "6m 44s", 5);
        songRepository.save(warpAsylum);


         Album nail = new Album(jawList,"Nail", "Foetus",
                 "https://upload.wikimedia.org/wikipedia/en/b/b5/Foetus_Nail.jpg",
                  "Self Immolation/Some Bizzare", "40m 4s", 5,
                 "https://www.youtube.com/embed/OnY63APl_6c",
                 "J.G. Thirlwell is a lyrical genius and this is his masterpiece.  One of the pioneers of the ‘industrial’ sound, and some classical overtures thrown in for good measure.  References run the gamut from Hamlet to Timothy Leary, to the Manson murders, to Jack and the Beanstalk.");
         albumRepository.save(nail);

         Song themePigdom = new Song(nail, "Theme from Pigdom Come", "1m 52s", 5);
         songRepository.save(themePigdom);

         Song throneAgony = new Song(nail, "The Throne of Agony", "5m 18s", 5);
         songRepository.save(throneAgony);

         Song exclamation = new Song(nail, "!", "0m 4s", 4);
         songRepository.save(exclamation);

         Song descentInferno = new Song(nail, "Descent into the Inferno", "6m 17s", 5);
         songRepository.save(descentInferno);

         Song enterExterminator = new Song(nail, "Enter the Exterminator", "4m 43s", 5);
         songRepository.save(enterExterminator);

         Song di19026 = new Song(nail, "DI-1-9026", "4m 40s", 5);
         songRepository.save(di19026);

         Song overturePigdom = new Song(nail, "The Overture from Pigdom Come", "3m 1s", 5);
         songRepository.save(overturePigdom);

         Song privateWar = new Song(nail, "Private War", "1m 6s", 5);
         songRepository.save(privateWar);

         Song anythingViva = new Song(nail, "Anything (Viva!)", "6m 50s", 5,
                 "The last three songs really combine to form one killer ‘get my ass fired up!’ anthem that should be required in every half time locker room speech.  Favorite Lyric: C’mon, man.  The ENTIRE song!");
         songRepository.save(anythingViva);


         Album extremities = new Album(jawList,"Extremities, Dirt and Various Repressed Emotions", "Killing Joke",
                 "https://upload.wikimedia.org/wikipedia/en/thumb/d/d2/Killing_scene_Extremeties_Dirt_%26_Various_Repressed_Emotions.jpg/220px-Killing_scene_Extremeties_Dirt_%26_Various_Repressed_Emotions.jpg",
                  "Noise", "1h 5m 8s", 5,
                 "https://www.youtube.com/embed/dCs0D6AJUuM",
                 "Quite the departure from their previous album “Outside the Gate” as Martin Atkins (PIL, Pigface) joins the band for a ‘one and done’ on drums.  This one turns it ‘up to 11’ with not only the power of the sound, but the lyrics as well.  So thankful to have seen them on tour at Bogarts in Cincy supporting this album.  Good times.");
         albumRepository.save(extremities);

         Song moneyGod = new Song(extremities, "Money Is Not Our God", "5m 17s", 5);
         songRepository.save(moneyGod);

         Song ageGreed = new Song(extremities, "Age of Greed", "7m 23s", 5,
                 "Great lyrics with great energy behind them.  If this song does not make you angry, you may not have a pulse.  Favorite Lyric: Your money, my time\n" +
                         "Your stinking industrial bathwater, my wine\n" +
                         "Imbalance induces hate\n" +
                         "How will you bridge the gap\n" +
                         "Between the endless buffet\n" +
                         "And the empty plate I have.");
         songRepository.save(ageGreed);

         Song beautifulDead = new Song(extremities, "The Beautiful Dead", "6m 2s", 5);
         songRepository.save(beautifulDead);

         Song extremitites = new Song(extremities, "Extremities", "5m 20s", 5);
         songRepository.save(extremitites);

         Song intraveneous = new Song(extremities, "Intravenous", "7m 2s", 5);
         songRepository.save(intraveneous);

         Song insideTermite = new Song(extremities, "Inside the Termite Mound", "7m 49s", 5);
         songRepository.save(insideTermite);

         Song solitude = new Song(extremities, "Solitude", "5m 2s", 5);
         songRepository.save(solitude);

         Song northBorder = new Song(extremities, "North of the Border", "5m 52s", 5);
         songRepository.save(northBorder);

         Song slipstream = new Song(extremities, "Slipstream", "7m 7s", 5);
         songRepository.save(slipstream);

         Song kaliyuga = new Song(extremities, "Kaliyuga", "2m 8s", 5);
         songRepository.save(kaliyuga);

         Song struggle = new Song(extremities, "Struggle", "6m 13s", 5);
         songRepository.save(struggle);


         Album killers = new Album(jawList,"Killers", "Iron Maiden",
                 "https://upload.wikimedia.org/wikipedia/en/thumb/b/b4/Iron_Maiden_Killers.jpg/220px-Iron_Maiden_Killers.jpg",
                  "EMI", "38m 18s", 5,
                 "https://www.youtube.com/embed/QUsibOlkt-o",
                 "When this album was released in 1981, I had no idea who Iron Maiden were, but Eddie on the cover and my friend telling me he thought that it might be ‘devil music’ sold me.  It was the hardest, fastest rock I had heard to that point, and an instant classic.  Bruce Dickinson famously joined the band on vocals after this album and they soared in popularity, but this is easily my favorite.  Another album where each song bleeds into the next.");
         albumRepository.save(killers);

         Song idesOfMarch = new Song(killers, "The Ides of March (instrumental)", "1m 48s", 5);
         songRepository.save(idesOfMarch);

         Song wrathchild = new Song(killers, "Wrathchild", "2m 54s", 5);
         songRepository.save(wrathchild);

         Song rueMorgue = new Song(killers, "Murders in the Rue Morgue", "4m 14s", 5);
         songRepository.save(rueMorgue);

         Song anotherLife = new Song(killers, "Another Life", "3m 22s", 5);
         songRepository.save(anotherLife);

         Song genghisKhan = new Song(killers, "Genghis Khan (instrumental)", "3m 2s", 5);
         songRepository.save(genghisKhan);

         Song innocentExile = new Song(killers, "Innocent Exile", "3m 50s", 5);
         songRepository.save(innocentExile);

         Song killersSong = new Song(killers, "Killers", "4m 58s", 5);
         songRepository.save(killersSong);

         Song prodigalSon = new Song(killers, "Prodigal Son", "6m 5s", 5,
                 "Beautiful and haunting.  Such a shame that the band doesn’t appear to agree as I don’t believe they have ever played it on tour.  Favorite Lyric: Oh Lamia, please, try to help me\n" +
                         "The devil's got a hold of my soul and he won't let me be\n" +
                         "Lamia, I've got this curse, I'm turning to bad\n" +
                         "The devil's got a hold of my soul, he's driving me mad.");
         songRepository.save(prodigalSon);

         Song purgatory = new Song(killers, "Purgatory", "3m 18s", 5);
         songRepository.save(purgatory);

         Song drifter = new Song(killers, "Drifter", "4m 47s", 5);
         songRepository.save(drifter);

         Album undertow = new Album(jawList,"Undertow", "Tool",
                 "https://upload.wikimedia.org/wikipedia/en/thumb/8/82/Tool-Undertow.jpg/220px-Tool-Undertow.jpg",
                  "Zoo", "1h 9m 13s", 5,
                 "https://www.youtube.com/embed/I8yoVlkLERs",
                 "Just perfection from the lyrics to the vocals and the full, raw power of the instruments.  Could listen to this on an endless loop, stopping only to occasionally skip Sober as it was a bit overplayed.  This album sold me on all things Maynard.");
         albumRepository.save(undertow);

         Song intolerance = new Song(undertow, "Intolerance", "4m 53s", 5);
         songRepository.save(intolerance);

         Song prisonSex = new Song(undertow, "Prison Sex", "4m 56s", 5);
         songRepository.save(prisonSex);

         Song sober = new Song(undertow, "Sober", "5m 6s", 4);
         songRepository.save(sober);

         Song bottom = new Song(undertow, "Bottom", "7m 14s", 5);
         songRepository.save(bottom);

         Song crawlAway = new Song(undertow, "Crawl Away", "5m 30s", 5);
         songRepository.save(crawlAway);

         Song swampSong = new Song(undertow, "Swamp Song", "5m 31s", 5,
                 "If your neck does not need a brace after listening to this song, you may not have a pulse.");
         songRepository.save(swampSong);

         Song undertowSong = new Song(undertow, "Undertow", "5m 22s", 5);
         songRepository.save(undertowSong);

         Song fourDegrees = new Song(undertow, "4°", "6m 3s", 5,
                 " Favorite Lyric: Locked up inside you\n" +
                         "Like the calm beneath castles\n" +
                         "Is a cavern of treasures that\n" +
                         "Noone has been to\n" +
                         "Let's go digging.");
         songRepository.save(fourDegrees);

         Song flood = new Song(undertow, "Flood", "7m 46s", 5);
         songRepository.save(flood);

         Song disgustipated = new Song(undertow, "Disgustipated", "15m 47s", 5,
                 "Favorite Lyric: Let the rabbits wear glasses");
         songRepository.save(disgustipated);


         List naList = new List("nana List");
         listStorage.saveList(naList);

         Album inASilentWay = new Album(naList,"In A Silent Way ","Miles Davis","https://www.bluescentric.com/images/product/large/4310.jpg","Columbia Records","38m 09s", 5, "https://www.youtube.com/watch?v=YHesqaMhh34","Miles Davies gave us a mighty touch with his 'In A Silent Way' album, It is a musical rebirth, a sense of motherly warmth takes over, and then we hear, yet again, Davis’ cosmic trumpet playing which concludes the album with a calming fade.");
         albumRepository.save(inASilentWay);

         Song shhPeaceful = new Song(inASilentWay,"Shhh / Peacefull","18m 30s",5,"This jam will have you tip-toeing around your house, very relaxing yet stimulating");
         songRepository.save(shhPeaceful);

         Song aboutThatTime = new Song(inASilentWay,"In A Silent /It's About That Time","20m 0s",5,"One of the smoothest jams on earth, This is a must listen for any jazz fans out there who wish to transcend into a groove");
         songRepository.save(aboutThatTime);


         Album zombie = new Album(naList,"Zombie","Fela Kuti", "https://is2-ssl.mzstatic.com/image/thumb/Music125/v4/64/02/1c/64021cbe-25b4-a38b-4495-88578359ca19/720841206194.jpg/270x270bb.webp","COCONUT","25m 41s",4,"https://www.youtube.com/watch?v=-3j0nugz1Pw&list=OLAK5uy_n4UDREKrRXJxqya81gWWhXN_5ImgFWtNM","Fela Kuti, a Nigerian Afrobeat and political activist released 'Zombie' in 1976 which has been one of his most political musical statement.");
         albumRepository.save(zombie);

         Song mrFollowFollow = new Song(zombie,"Mr. Follow Follow","12m 58s",5,"'Mr. Follow Follow' has a deeper commentary and a clearer theme about conformity as it relates to the military and the state. ");
         songRepository.save(mrFollowFollow);

         Song observationIsNoCrime = new Song(zombie,"Observation Is No Crime","13m 26s",5);
         songRepository.save(observationIsNoCrime);

         Song mistake = new Song(zombie,"Mistake (Live at the Berlin Jazz Festival, 1978)","14m 47s",5);
         songRepository.save(mistake);

         Song zombieo = new Song(zombie,"zombie", "12m 26s",5);
         songRepository.save(zombieo);


         Album conflict = new Album(naList,"Conflict","Ebo Taylor & Uhuru Yenzu","https://f4.bcbits.com/img/a2585325512_16.jpg","Mr. Bongo","31m 19s",4,"https://www.youtube.com/watch?v=Q54D5EVtRsQ","The album is both, mesmerizing and beautiful, and stands up well to many of the other monumental releases by Ebo Taylor. This album shows Ebo Taylor’s trademark approach that saw him inject a heavy dose of funk into Ghanaian traditional highlife grooves in an attempt to move away from what he saw as the music’s more traditional qualities.");
         albumRepository.save(conflict);

         Song youNeedLove = new Song(conflict,"You Need Love", "07m 09s",5, "A classic");
         songRepository.save(youNeedLove);

         Song loveAndDeath = new Song(conflict,"Love And Death","08m 19s",4);
         songRepository.save(loveAndDeath);

         Song whatIsLife = new Song(conflict,"What Is Life","04m 37s",4);
         songRepository.save(whatIsLife);

         Song christWillCome = new Song(conflict,"Christ Will Come","06m 58s",4);
         songRepository.save(christWillCome);

         Song victory = new Song(conflict,"Victory","04m 16s",4);
         songRepository.save(victory);



         List harrisonList = new List("harrison List");
         listStorage.saveList(harrisonList);

         Album foodAndLiquor = new Album(harrisonList,"Lupe Fiasco's Food & Liquor ","Lupe Fiasco","https://images-na.ssl-images-amazon.com/images/I/81B4l7WTz3L._SL1453_.jpg","Atlantic Records","72m 13s", 4, "https://www.youtube.com/watch?v=Gl83mI69nX4","blah blah blah");
         albumRepository.save(foodAndLiquor);

         Song intro = new Song(foodAndLiquor,"Intro","3m 7s",5);
         songRepository.save(intro);

         Song real = new Song(foodAndLiquor,"Real (featuring Sarah Green)","4m 2s",4);
         songRepository.save(real);

         Song justMightBeOK = new Song(foodAndLiquor,"Just Might Be OK (featuring Gemini)","4m 24s",5);
         songRepository.save(justMightBeOK);

         Song kickPush = new Song(foodAndLiquor,"Kick, Push","4m 13s",5);
         songRepository.save(kickPush);

         Song iGotcha = new Song(foodAndLiquor,"I Gotcha","3m 59s",5);
         songRepository.save(iGotcha);

         Song heSaySheSay = new Song(foodAndLiquor,"He Say She Say","4m 12s",5);
         songRepository.save(heSaySheSay);

         Song sunshine = new Song(foodAndLiquor,"Sunshine","3m 55s",5);
         songRepository.save(sunshine);

         Song daydreamin = new Song(foodAndLiquor,"Daydreamin' (featuring Jill Scott)","3m 55s",5);
         songRepository.save(daydreamin);

         Song theCool = new Song(foodAndLiquor,"The Cool","3m 46s",5);
         songRepository.save(theCool);

         Song hurtMeSoul = new Song(foodAndLiquor,"Hurt Me Soul","4m 22s",5);
         songRepository.save(hurtMeSoul);

         Song pressure = new Song(foodAndLiquor,"Pressure (featuring Jay-Z)","4m 47s",3);
         songRepository.save(pressure);

         Song americanTerrorist = new Song(foodAndLiquor,"American Terrorist (featuring Matthew Santos)","4m 40s",5);
         songRepository.save(americanTerrorist);

         Song theEmperorsSoundtrack = new Song(foodAndLiquor,"The Emperor's Soundtrack","2m 56s",3);
         songRepository.save(theEmperorsSoundtrack);

         Song kickPush2 = new Song(foodAndLiquor,"Kick, Push II","4m 11s",5);
         songRepository.save(kickPush2);

         Song outro = new Song(foodAndLiquor,"Outro","12m 13s",5);
         songRepository.save(outro);


         Album rapture = new Album(harrisonList,"Rapture","Anita Baker", "https://images-na.ssl-images-amazon.com/images/I/71bd2KuN3lL._SL1425_.jpg","Elektra","37m 9s",5,"https://www.youtube.com/watch?v=QlhZPNv7f8Q","tbd.");
         albumRepository.save(rapture);

         Song sweetLove = new Song(rapture,"Sweet Love","4m 26s",5);
         songRepository.save(sweetLove);

         Song youBringMeJoy = new Song(rapture,"You Bring Me Joy","4m 24s",5);
         songRepository.save(youBringMeJoy);

         Song caughtUpInTheRapture = new Song(rapture,"Caught Up In The Rapture","5m 17s",5);
         songRepository.save(caughtUpInTheRapture);

         Song beenSoLong = new Song(rapture,"Been So Long","5m 7s",4);
         songRepository.save(beenSoLong);

         Song mystery = new Song(rapture,"Mystery","4m 56s",5);
         songRepository.save(mystery);

         Song noOneInTheWorld = new Song(rapture,"No One In The World","4m 10s",5);
         songRepository.save(noOneInTheWorld);

         Song sameOleLove = new Song(rapture,"Same Ole Love (365 Days a Year)","4m 5s",4);
         songRepository.save(sameOleLove);

         Song watchYourStep = new Song(rapture,"Watch Your Step","4m 54s",4);
         songRepository.save(watchYourStep);

         Album itIsWhatItIsAlbum = new Album(harrisonList,"It Is What It Is","Thundercat", "https://images-na.ssl-images-amazon.com/images/I/616DGD29eaL._SL1200_.jpg","Brainfeeder","37m 38s",5,"https://www.youtube.com/watch?v=ormQQG2UhtQ","tbd.");
         albumRepository.save(itIsWhatItIsAlbum);

         Song lostInSpace = new Song(itIsWhatItIsAlbum,"Lost In Space / Great Scott / 22-26","1m 22s",5);
         songRepository.save(lostInSpace);

         Song interstellerLove = new Song(itIsWhatItIsAlbum,"Intersteller Love","2m 41s",5);
         songRepository.save(interstellerLove);

         Song iLoveLouisCole = new Song(itIsWhatItIsAlbum,"I Love Louis Cole (featuring Louis Cole)","3m 24s",5);
         songRepository.save(iLoveLouisCole);

         Song blackQualls = new Song(itIsWhatItIsAlbum,"Black Qualls (featuring Steve Lacy, Steve Arlington & Childish Gambino)","3m 09s",5);
         songRepository.save(blackQualls);

         Song miguelsHappyDance = new Song(itIsWhatItIsAlbum,"Miguel's Happy Dance","2m 11s",5);
         songRepository.save(miguelsHappyDance);

         Song howSway = new Song(itIsWhatItIsAlbum,"How Sway","1m 14s",5);
         songRepository.save(howSway);

         Song overseas = new Song(itIsWhatItIsAlbum,"Overseas (featuring Zack Fox)","1m 28s",5);
         songRepository.save(overseas);

         Song dragonballDurag = new Song(itIsWhatItIsAlbum,"Dragonball Durag","3m 01s",5);
         songRepository.save(dragonballDurag);

         Song howIFeel = new Song(itIsWhatItIsAlbum,"How I Feel","1m 08s",5);
         songRepository.save(howIFeel);

         Song kingOfTheHill = new Song(itIsWhatItIsAlbum,"King of the Hill","2m 51s",5);
         songRepository.save(kingOfTheHill);

         Song unrequitedLove = new Song(itIsWhatItIsAlbum,"Unrequited Love","3m 14s",5);
         songRepository.save(unrequitedLove);

         Song fairChance = new Song(itIsWhatItIsAlbum,"Fair Chance (featuring Ty Dolla $ign & Lil B","3m 57s",5);
         songRepository.save(fairChance);

         Song existentialDread = new Song(itIsWhatItIsAlbum,"Existential Dread"," 51s",5);
         songRepository.save(existentialDread);

         Song itIsWhatItIsSong = new Song(itIsWhatItIsAlbum,"It Is What It Is","5m 02s",5);
         songRepository.save(itIsWhatItIsSong); 

         Album rapture = new Album(harrisonList,"Rapture","Anita Baker", "https://images-na.ssl-images-amazon.com/images/I/71bd2KuN3lL._SL1425_.jpg","Elektra","37m 9s",5,"https://www.youtube.com/watch?v=QlhZPNv7f8Q","tbd.");
         albumRepository.save(rapture);

         Song sweetLove = new Song(rapture,"Sweet Love","4m 26s",5);
         songRepository.save(sweetLove);

         Song youBringMeJoy = new Song(rapture,"You Bring Me Joy","4m 24s",5);
         songRepository.save(youBringMeJoy);

         Song caughtUpInTheRapture = new Song(rapture,"Caught Up In The Rapture","5m 17s",5);
         songRepository.save(caughtUpInTheRapture);

         Song beenSoLong = new Song(rapture,"Been So Long","5m 7s",4);
         songRepository.save(beenSoLong);

         Song mystery = new Song(rapture,"Mystery","4m 56s",5);
         songRepository.save(mystery);

         Song noOneInTheWorld = new Song(rapture,"No One In The World","4m 10s",5);
         songRepository.save(noOneInTheWorld);

         Song sameOleLove = new Song(rapture,"Same Ole Love (365 Days a Year)","4m 5s",4);
         songRepository.save(sameOleLove);

         Song watchYourStep = new Song(rapture,"Watch Your Step","4m 54s",4);
         songRepository.save(watchYourStep);

         Album driftAwayAlbum = new Album(harrisonList,"Drift Away","Dobbie Gray", "https://images-na.ssl-images-amazon.com/images/I/61V6GSSQS9L._SY355_.jpg","Decca","34m 37s",5,"https://www.youtube.com/watch?v=NIuyDWzctgY","tbd.");
         albumRepository.save(driftAwayAlbum);

         Song driftAwaySong = new Song(driftAwayAlbum,"Drift Away","3m 57s",5);
         songRepository.save(driftAwaySong);

         Song theTimeILoveYou = new Song(driftAwayAlbum,"The Time I Love You the Most","3m 13s",5);
         songRepository.save(theTimeILoveYou);

         Song laLady = new Song(driftAwayAlbum,"L.A. Lady","2m 53s",5);
         songRepository.save(iLoveLouisCole);

         Song weHadItAll = new Song(driftAwayAlbum,"We Had It All","2m 43s",5);
         songRepository.save(blackQualls);

         Song nowThatImWithoutYou = new Song(driftAwayAlbum,"Now That I'm Without You","3m 26s",5);
         songRepository.save(nowThatImWithoutYou);

         Song rockinChair = new Song(driftAwayAlbum,"Rockin' Chair","3m 34s",5);
         songRepository.save(rockinChair);

         Song layBack = new Song(driftAwayAlbum,"Lay Back","2m 22s",4);
         songRepository.save(layBack);

         Song cityStars = new Song(driftAwayAlbum,"City Stars","3m 32s",5);
         songRepository.save(cityStars);

         Song sweetLovinWoman = new Song(driftAwayAlbum,"Sweet Lovin' Woman","2m 42s",5);
         songRepository.save(sweetLovinWoman);

         Song caddoQueen = new Song(driftAwayAlbum,"Caddo Queen","3m 29s",4);
         songRepository.save(caddoQueen);

         Song eddiesSong = new Song(driftAwayAlbum,"Eddie's Song","2m 46s",5);
         songRepository.save(eddiesSong);

         Album liveInEurope = new Album(harrisonList,"Live In Eurpoe","Otis Redding", "https://images-na.ssl-images-amazon.com/images/I/71wTXzY08CL._SL1425_.jpg","Volt/Atco","32m 56s",5,"https://www.youtube.com/watch?v=xDqL0XCs3V4","tbd.");
         albumRepository.save(liveInEurope);

         Song respect = new Song(liveInEurope,"Respect","3m",5);
         songRepository.save(respect);

         Song cantTurnYouLoose = new Song(liveInEurope,"Can't Turn You Loose","3m 20s",4);
         songRepository.save(cantTurnYouLoose);

         Song iveBeenLovingYou = new Song(liveInEurope,"I've Been Loving You Too Long","3m 40s",5);
         songRepository.save(iveBeenLovingYou);

         Song myGirl = new Song(liveInEurope,"My Girl","2m 43s",5);
         songRepository.save(myGirl);

         Song shake = new Song(liveInEurope,"Shake","2m 51s",5);
         songRepository.save(shake);

         Song satisfaction = new Song(liveInEurope,"(I Can't Get No) Satisfaction","2m 53s",3);
         songRepository.save(satisfaction);

         Song faFaFaFa = new Song(liveInEurope,"Fa-Fa-Fa-Fa-Fa (Sad Song)","3m 37s",5);
         songRepository.save(faFaFaFa);

         Song theseFarmsOfMine = new Song(liveInEurope,"These Arms of Mine","2m 57s",5);
         songRepository.save(theseFarmsOfMine);

         Song dayTripper = new Song(liveInEurope,"Day Tripper","2m 54s",5);
         songRepository.save(dayTripper);

         Song tryALittle = new Song(liveInEurope,"Try A Little Tenderness","5m",5);
         songRepository.save(tryALittle);


         //George's List
         List georgeList = new List("George's List");
         listStorage.saveList(georgeList);

         Album underSoilAndDirt = new Album(georgeList,"Under Soil and Dirt","The Story So Far",
				"https://upload.wikimedia.org/wikipedia/en/c/c3/Under_Soil_And_Dirt_by_The_Story_So_Far_front_album_cover.jpg",
				"Pure Noise","32m 12s", 5, "https://www.youtube.com/watch?v=Ndx1uhYA6DE&list=PL08971D6ED3A4EFD3",
				"This album brought pop-punk back to its roots. A little heavy for the genre, but a classic.");
         albumRepository.save(underSoilAndDirt);

         Song statesAndMinds = new Song(underSoilAndDirt,"States and Minds","51s",3);
         songRepository.save(statesAndMinds);

         Song roam = new Song(underSoilAndDirt,"Roam","2m 54s",4);
         songRepository.save(roam);

         Song quicksand = new Song(underSoilAndDirt,"Quicksand","2m 38s",5,"This is the song that launched the band!");
         songRepository.save(quicksand);

         Song swordsAndPens = new Song(underSoilAndDirt,"Swords and Pens","3m 9s",5);
         songRepository.save(swordsAndPens);

         Song highRegard = new Song(underSoilAndDirt,"High Regard","3m 51s",4);
         songRepository.save(highRegard);

         Song daughters = new Song(underSoilAndDirt,"Daughters","3m 6s",5,"Song about bad girls in college.");
         songRepository.save(daughters);

         Song mtDiablo = new Song(underSoilAndDirt,"Mt. Diablo","4m 9s",5,"This song has one of the best lines in all of music!");
         songRepository.save(mtDiablo);

         Song fourYears = new Song(underSoilAndDirt,"Four Years","2m 44s",4);
         songRepository.save(fourYears);

         Song rallyCap = new Song(underSoilAndDirt,"Rally Cap","2m 18s",5);
         songRepository.save(rallyCap);

         Song placeholder = new Song(underSoilAndDirt,"Placeholder","3m 5s",4);
         songRepository.save(placeholder);

         Song closure = new Song(underSoilAndDirt,"Closure","3m 19s",4,"Strong outro.");
         songRepository.save(closure);
    }
}