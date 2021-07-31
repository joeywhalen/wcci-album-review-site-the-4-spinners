package org.wcci.apimastery.resources;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity 
public class Album {

    @Id
    @GeneratedValue
    @Column(name="ALBUM_ID")
    private Long id; 

    private String title;
    private String artist;
    private String imageURL;
    private String recordLabel;
    private String duration;
    private int rating;
    private String videoUrl;

    @ManyToOne
    @JsonIgnore
    private List list;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Song> songs;
    
    @Lob
    @ElementCollection
    private Collection<String> comments;

    protected Album(){

    }

    public Album (List list, String title, String artist, String imageURL, String recordLabel, String duration, int rating, String videoUrl, String... comments){
        this.list = list;
        this.title = title;
        this.artist = artist;
        this.imageURL = imageURL;
        this.songs = new ArrayList<Song>();
        this.recordLabel = recordLabel;
        this.duration = duration;
        this.rating = rating;
        this.videoUrl = videoUrl;
        this.comments = Set.of(comments);
    }

    public List getList() {
        return list;
    }

    public long getListId(){
        return list.getId();
    }

    public void changeList(List list) {
        this.list = list;
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

    public String getImageURL() {
        return imageURL;
    }
    
    public void addSong(Song song) {
        songs.add(song);
    }

    public boolean hasSongs() {
        if (songs != null && songs.size() > 0) {
            return true;
        }
        return false;
    }

    public Collection<Song> getSongs() {
        return songs;
    }

    public void deleteSongs() {
        songs.clear();
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    public String getRecordLabel(){
        return recordLabel;
    }

    public String getduration(){
        return duration;
    }

    public int getRating(){
        return rating;
    }

    public String getVideoUrl(){
        return videoUrl;
    }

    public Iterable<String> getComments() {
        return comments;
    }
    
    public void addComment(String newComment) {
        this.comments.add(newComment);
    }

    public void changeAlbumTitle(String newAlbumTitle) {
        this.title = newAlbumTitle;
    }
    
}