package org.wcci.apimastery.resources;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
//    private String song;
    private String recordLabel;
    private String duration;
    private int rating;
    private String videoUrl;



    @ManyToOne
    @JsonIgnore
    private List list;

//    @ManyToMany(mappedBy = "albums")
//    private Collection<Song> songs;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Song> songs;
    
    @Lob
    @ElementCollection
//    @CollectionTable(name="COMMENTS", joinColumns=@JoinColumn(name="COMMENT_ID"))
//    @ManyToOne (mappedBy = "albums")
    private Collection<String> comments;

    protected Album(){

    }

    public Album (List list, String title, String artist, String imageURL, String recordLabel, String duration, int rating, String videoUrl, String... comments){
        this.list = list;
        this.title = title;
        this.artist = artist;
        this.imageURL = imageURL;
//        this.song = song;
        this.recordLabel = recordLabel;
        this.duration = duration;
        this.rating = rating;
        this.videoUrl = videoUrl;
        this.comments = Set.of(comments);
    }

    public List getList() {
        return list;
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

    public Collection<Song> getSongs() {
        return songs;
    }

    //    public String getSong(){
//        return song;
//    }

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

    public Iterable<String> getComments(){
        return comments;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void changeList(List list) {
        this.list = list;
    }

    public void deleteSongs(){
        songs.clear();
    }

}