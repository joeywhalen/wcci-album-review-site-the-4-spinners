package org.wcci.apimastery.storage;

import org.springframework.data.repository.CrudRepository;

import org.wcci.apimastery.resources.List;

public interface ListRepository extends CrudRepository<List, Long> {

}
