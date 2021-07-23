package org.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Lob;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.CollectionTable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;

@Enitity
public class Song {
    private String songTitle;
    private int length;
    

    @Id
    @GeneratedValue
    @Column(name="SONG_ID")
    private Long id;

    @Lob
    @ElementCollection
    @CollectionTable(name="COMMENTS", joinColumns=@JoinColumn(name="COMMENT_ID"))
    @OneToMany(mappedBy = "songs")
    private Collection<Comment> comments;

    private int starRating;
  
    protected Song() {
    };



    public Song(String songTitle, int length, int starRating) {
        this.songTitle = songTitle;
        this.length = length;        
        this.starRating = starRating;
        
    }

    public String getSong() {
        return songTitle;
    }

    public int getLength() {
        return length;
    }

    public int getStarRating(){
        return starRating;

    }

    public Long getId() {
        return id;
    }

    public Iterable<Song> getSongs() {
        return songs;
    }

    public void addSong(Song songTitle) {
        songs.add(songTitle);
    }
}