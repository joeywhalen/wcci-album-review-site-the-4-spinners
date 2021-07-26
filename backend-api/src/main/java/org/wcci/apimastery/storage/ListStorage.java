package org.wcci.apimastery.storage;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.resources.List;


@Service
public class ListStorage {
    private ListRepository listRepository;

    public ListStorage(ListRepository listRepository){
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
