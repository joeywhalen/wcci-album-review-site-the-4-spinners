package org.storage;
import org.resources.List;
import org.springframework.stereotype.Service;


@Service
public class ListStorage {
    private ListRepository listRepository;

    private ListStorage(ListRepository listRepository){
        this.listRepository = listRepository;
    }

    public List retrieveListById(Long id){
        return listRepository.findById(id).get();
    }

    public void saveList(List listToSave){
        listRepository.save(listToSave);
    }

    public Iterable<List> retrieveAllList(){
        return listRepository.findAll();
    }

    public void deleteListById(Long id){
        listRepository.deleteById(id);
    }
}
