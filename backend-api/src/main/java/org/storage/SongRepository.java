package org.storage;

import org.springframework.data.repository.CrudRepository;
import org.resources.Song;

public interface SongRepository extends CrudRepository<Song, Long> {

}
