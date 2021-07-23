package org.resources;

import javax.persistence.Entity;

@Entity
public class Entity {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private String userComment;

    @ManyToOne
    private Album albums;

    @ManyToOne
    private Song songs;

    public Comment(String userComment, Album albums, Song songs) {
        this.userComment = userComment;
        this.albums = albums;
        this.songs = songs;
    }

    protected Comment() {

    }
    

}
