import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;

@Enitity
public class Song {
    private String song;
    private int length;

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "songs")
    private Collection<Comment> comment;

    private int starRating;

    protected Song() {
    };

}

    public Song(String song, int length, int starRating) {
        this.song = song;
        this.length = length;
    }

    public String getSong() {
        return song;
    }

    public int getLength() {
        return length;
    }

    public Long getId() {
        return id;
    }

    public Iterable<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        songs.add(song);
    }
