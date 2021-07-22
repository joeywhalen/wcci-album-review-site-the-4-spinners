import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;

@Enitity
public class Song {
    private String songTitle;
    private int length;
    

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "songs")
    private Collection<Comment> comments;

    private int starRating;
    private String videoUrl;

    protected Song() {
    };



    public Song(String songTitle, int length, int starRating, String videoUrl) {
        this.songTitle = songTitle;
        this.length = length;        
        this.starRating = starRating;
        this.videoUrl = videoUrl;
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