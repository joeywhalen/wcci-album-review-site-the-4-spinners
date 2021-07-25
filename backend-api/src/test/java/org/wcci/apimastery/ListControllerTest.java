package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wcci.apimastery.controllers.ListController;
import org.wcci.apimastery.resources.List;
import org.wcci.apimastery.storage.ListStorage;

import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListControllerTest {

    private ListStorage listStorage;
    private ListController underTest;

    @BeforeEach
    void setUp() {
        listStorage = mock(ListStorage.class);
        underTest = new ListController(listStorage);
        when(listStorage.retrieveAllList()).thenReturn(Collections.singletonList(new List("testList")));
    }

    @Test
    public void shouldRetrieveAllLists() {
        Iterable<List> lists = underTest.retrieveAllList();
    }
}
