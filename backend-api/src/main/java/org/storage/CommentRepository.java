package org.storage;

import org.springframework.data.repository.CrudRepository;
import org.resources.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
