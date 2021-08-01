package org.wcci.apimastery.resources;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
public class Song {
    private String songTitle;
    private String length;

    @Id
    @GeneratedValue
    @Column(name="SONG_ID")
    private Long id;

    @ManyToOne
    @JsonIgnore
    private Album album;

    @ElementCollection
    private Collection<Integer> songUserRatings;

    @Lob
    @ElementCollection
    private Collection<String> comments;

    private int starRating;
  
    protected Song() {
    };

    public Song(Album album, String songTitle, String length, int starRating, String... comments) {
        this.album = album;
        this.songTitle = songTitle;
        this.length = length;
        this.starRating = starRating;
        this.songUserRatings = new ArrayList<Integer>();
        this.comments = Set.of(comments);
    }

    public Album getAlbum() {
        return album;
    }
    
    public long getAlbumId(){
        return album.getId();
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getLength() {
        return length;
    }

    public int getStarRating(){
        return starRating;
    }

    public Long getId() {
        return id;
    }

    public void addSongComment(String newSongComment) {
        this.comments.add(newSongComment);
    }

    public Iterable<String> getComments() {
        return comments;
    }

    public Iterable<Integer> getSongUserRatings() {
        return songUserRatings;
    }

    public void addSongUserRating(Integer newSongUserRating) {
        this.songUserRatings.add(newSongUserRating);
    }

    public long getListId(){
        return album.getList().getId();
    }
    public void addAlbum(Album album){
        this.album = album;
    }

    public void changeSongTitle(String newSongTitle){
        this.songTitle = newSongTitle;
    }

}