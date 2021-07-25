package org.wcci.apimastery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.apimastery.storage.AlbumRepository;
import org.wcci.apimastery.storage.ListRepository;
import org.wcci.apimastery.storage.SongRepository;

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

    
}
