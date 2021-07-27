package org.wcci.apimastery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.wcci.apimastery.controllers.ListController;
import org.wcci.apimastery.storage.ListStorage;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SmokeTests {
    @Autowired
    private ListController listController;
    @Autowired
    private ListStorage listStorage;

    @Test
    void contextLoads(){ }

    @Test
    void beanCreation(){
        assertNotNull(listController);
        assertNotNull(listStorage);
    }
}
