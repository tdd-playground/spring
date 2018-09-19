package com.tdd.demo.repositories;

import com.tdd.demo.domain.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

// Annotation that can be used in combination with @RunWith(SpringRunner.class) for a typical JPA test.
// Can be used when a test focuses only on JPA components.
// Using this annotation will disable full auto-configuration and instead apply only configuration relevant to JPA tests.
// By default, tests annotated with @DataJpaTest will use an embedded in-memory database (replacing any explicit or usually auto-configured DataSource).
// If you are looking to load your full application configuration, but use an embedded database,
// you should consider @SpringBootTest combined with @AutoConfigureTestDatabase rather than this annotation.
@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testFindAll_callingFindAllMethod_returnsAll() {
        // Tests like these are probably overkill - loads data from data.sql
        // For external real-world database over in-memory, you should move data.sql to src/test/java
        List<Item> itemList = itemRepository.findAll();
        assertEquals(4, itemList.size());
    }
}
