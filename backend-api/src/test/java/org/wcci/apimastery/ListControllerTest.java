package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.apimastery.controllers.ListController;
import org.wcci.apimastery.resources.List;
import org.wcci.apimastery.storage.ListStorage;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        //Arrangement
        //Action
        Iterable<List> lists = underTest.retrieveAllList();
        //Assertion
        assertThat(lists).contains(new List("testList"));
    }

    @Test
    public void retrieveAllListShouldBeMappedCorrectly() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(get("/api/lists")).andExpect(status().isOk());
    }
}
