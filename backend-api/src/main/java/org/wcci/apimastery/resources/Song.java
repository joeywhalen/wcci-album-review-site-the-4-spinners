package org.wcci.apimastery.resources;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

//    @ManyToMany
//    private Collection<Album> albums;

    @Lob
    @ElementCollection
//    @CollectionTable(name="COMMENTS", joinColumns=@JoinColumn(name="COMMENT_ID"))
//    @OneToMany(mappedBy = "songs")
    private Collection<String> comments;

    private int starRating;
  
    protected Song() {
    };

    public Song(Album album, String songTitle, String length, int starRating, String... comments) {
        this.album = album;
        this.songTitle = songTitle;
        this.length = length;
        this.starRating = starRating;
        this.comments = Set.of(comments);
    }

    public Album getAlbum() {
        return album;
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

    public Iterable<String> getComments() {
        return comments;
    }
    public void addAlbum(Album album){
        this.album = album;
    }

    public void changeSongTitle(String newSongTitle){
        this.songTitle = newSongTitle;
    }
}