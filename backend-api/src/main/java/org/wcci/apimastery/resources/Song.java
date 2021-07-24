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

    @ManyToMany
    private Collection<Album> albums;

    @Lob
    @ElementCollection
//    @CollectionTable(name="COMMENTS", joinColumns=@JoinColumn(name="COMMENT_ID"))
//    @OneToMany(mappedBy = "songs")
    private Collection<String> comments;

    private int starRating;
  
    protected Song() {
    };

    public Song(String songTitle, String length, int starRating, String... comments) {
        this.songTitle = songTitle;
        this.length = length;
        this.starRating = starRating;
        this.comments = Set.of(comments);
    }

    public String getSong() {
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

}