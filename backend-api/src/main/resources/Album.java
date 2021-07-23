package org.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Lob;
import java.util.Collection;

@Entity 
public class Album {

    @Id
    @GeneratedValue
    private Long id; 

    private String title;
    private String artist;
    private String imageURL;
    private String song;
    private String recordLabel;
    private int duration;
    private int rating;
    private String videoUrl;
    
    @Lob
    @ManyToOne (mappedBy = "albums")
    private Collection<Comment> commments;

    protected Album(){

    }

    public Album (String title, String artist, String imageURL, String song, String recordLabel, int duration, int rating, String videoUrl){
        this.title = title;
        this.artist = artist;
        this.imageURL = imageURL;
        this.song = song;
        this.recordLabel = recordLabel;
        this.duration = duration;
        this.rating = rating;
        this.videoUrl = videoUrl;
    }

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getArtist(){
        return artist;
    }

    public String getImageURL(){
        return imageURL;
    }

    public String getSong(){
        return song;
    }

    public String getRecordLabel(){
        return recordLabel;
    }

    public int getduration(){
        return duration;
    }

    public int getRating(){
        return rating;
    }

    public String getVideoUrl(){
        return videoUrl;
    }

    public Iterable<Comment> getComments(){
        return comments;
    }

}