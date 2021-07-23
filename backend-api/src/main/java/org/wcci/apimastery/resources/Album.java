package org.wcci.apimastery.resources;



import javax.persistence.*;
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
    private String song;
    private String recordLabel;
    private int duration;
    private int rating;
    private String videoUrl;



    @ManyToOne
    private List list;

    @ManyToMany(mappedBy = "albums")
    private Collection<Song> songs;
    
    @Lob
    @ElementCollection
//    @CollectionTable(name="COMMENTS", joinColumns=@JoinColumn(name="COMMENT_ID"))
//    @ManyToOne (mappedBy = "albums")
    private Collection<String> comments;

    protected Album(){

    }

    public Album (String title, String artist, String imageURL, String song, String recordLabel, int duration, int rating, String videoUrl, String... comments){
        this.title = title;
        this.artist = artist;
        this.imageURL = imageURL;
        this.song = song;
        this.recordLabel = recordLabel;
        this.duration = duration;
        this.rating = rating;
        this.videoUrl = videoUrl;
        this.comments = Set.of(comments);
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

    public Iterable<String> getComments(){
        return comments;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

}