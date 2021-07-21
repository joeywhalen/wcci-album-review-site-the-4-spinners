
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class List {
    private List name;

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "list")
    private Collection<Album> albums;

    protected List() {

    }

    public List(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Iterable<Album> getAlbums() {
        return albums;
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }
}