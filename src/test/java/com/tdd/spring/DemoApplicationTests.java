package com.tdd.spring;

import com.tdd.spring.domain.Item;
import com.tdd.spring.repositories.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

// This is the outline for an integration test (IT) - see SpringControllersIT
// Integration tests do not want actual integration with external APIs or databases, but they do need to confirm
// that all the layers are interacting as you would expect.
// SpringBootTest will automatically load up an in-memory database, but what about APIs? --> You can use @MockBean
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Don't use same port as Spring Boot Application
@TestPropertySource(locations = {"classpath:test-application.properties"})
public class DemoApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean // You can mock any DI based dependency in an Integration Test
    private ItemRepository itemRepository;

    @Test
    public void contextLoads() throws Exception {
        List<Item> listToReturn = Arrays.asList(
                new Item(1, "Some Item 1"),
                new Item(2, "Some Item 2")
        );
        when(itemRepository.findAll()).thenReturn(listToReturn);
        String result = this.restTemplate.getForObject("/foo/items", String.class);
        JSONAssert.assertEquals("[{id: 1},{id: 2}]", result, false);
    }
}
