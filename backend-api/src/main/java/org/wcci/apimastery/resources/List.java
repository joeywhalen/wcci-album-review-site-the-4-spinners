package org.wcci.apimastery.resources;
import javax.persistence.*;
import java.util.Collection;

@Entity
public class List {
    private String listName;

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Album> albums;

    protected List() {

    }

    public List(String listName) {
        this.listName = listName;
    }

    public Long getId() {
        return id;
    }

    public String getListName() {
        return listName;
    }

    public Iterable<Album> getAlbums() {
        return albums;
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public void changeListName(String newListName) {
        listName = newListName;
    }
}