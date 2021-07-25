package org.wcci.apimastery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.apimastery.resources.Album;
import org.wcci.apimastery.resources.List;
import org.wcci.apimastery.resources.Song;
import org.wcci.apimastery.storage.AlbumRepository;
import org.wcci.apimastery.storage.ListRepository;
import org.wcci.apimastery.storage.SongRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaWiringTest {

    @Autowired
    private ListRepository listRepository;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private SongRepository songRepository;

    @Test
    public void listRepositoryShouldSaveAndRetrieveListObjects() {
        List testList = new List("listName");
        listRepository.save(testList);
        List retrievedList = listRepository.findById(testList.getId()).get();
        assertThat(retrievedList).isEqualTo(testList);
    }

    @Test
    public void albumRepoShouldSaveAndRetrieveAlbumObjects() {
        List testList = new List("listName");
        Album testAlbum = new Album(testList, "Album title","Artist", "WWW.com",
                "Record label", "90", 5,"video.com");
        albumRepository.save(testAlbum);
        Album retrievedAlbum = albumRepository.findById(testAlbum.getId()).get();
        assertThat(retrievedAlbum).isEqualTo(testAlbum);
    }

    @Test
    public void songRepoShouldSaveAndRetrieveSongObjects() {
        List testList = new List("listName");
        Album testAlbum = new Album(testList, "Album title","Artist", "WWW.com",
                "Record label", "90", 5,"video.com");
        Song testSong = new Song(testAlbum, "sing song", "90", 5);
        songRepository.save(testSong);
        Song retrievedSong = songRepository.findById(testSong.getId()).get();
        assertThat(retrievedSong).isEqualTo(testSong);
    }
}
