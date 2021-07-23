package org.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Lob;

@Entity
public class Comment {

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

    public Long getId() {
        return id;
    }

     public String getUserComment() {
        return userComment;
    }

    public Album getAlbums() {
        return albums;
    }

    public Song getSongs() {
        return songs;
    }


}
