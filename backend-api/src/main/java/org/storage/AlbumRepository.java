package org.storage;

import org.springframework.data.repository.CrudRepository;
import org.resources.Album;

public interface AlbumRepository extends CrudRepository<Album, Long> {

}
