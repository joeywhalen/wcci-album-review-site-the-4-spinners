package org.wcci.apimastery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.apimastery.resources.Album;
import org.wcci.apimastery.resources.List;
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

    private void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    public void listRepositoryShouldSaveAndRetrieveListObjects() {
        List testList = new List("listName");
        listRepository.save(testList);
//        flushAndClear();
        List retrievedList = listRepository.findById(testList.getId()).get();
        assertThat(retrievedList).isEqualTo(testList);
    }

    @Test
    public void albumRepoShouldSaveAndRetrieveAlbumObjects() {
        List testList = new List("listName");
        Album testAlbum = new Album(testList, "Album title","Artist", "WWW.com",
                "Record label", "90", 5,"video.com");
        albumRepository.save(testAlbum);
//        flushAndClear();
        Album retrievedAlbum = albumRepository.findById(testAlbum.getId()).get();
        assertThat(retrievedAlbum).isEqualTo(testAlbum);
    }
}
