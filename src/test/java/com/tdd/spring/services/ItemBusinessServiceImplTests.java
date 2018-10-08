package com.tdd.spring.services;

import com.tdd.spring.domain.Item;
import com.tdd.spring.repositories.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

// Business layers won't need Spring to Unit Test at all, plain Mockito
@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceImplTests {

    @InjectMocks
    ItemBusinessService itemBusinessService = new ItemBusinessServiceImpl();

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void getItemFromRepository_retrieveAllItems_returnsAllItems() {
        List<Item> listToReturn = Arrays.asList(
                new Item(1, "Some Item 1"),
                new Item(2, "Some Item 2")
        );
        when(itemRepository.findAll()).thenReturn(listToReturn);

        List<Item> itemsFromRepository = itemBusinessService.getItemsFromRepository();
        assertEquals(itemsFromRepository, listToReturn);

        // Playing with AssertJ conditions
        Item doesNotContain = new Item(1, "Don't contain me");
        assertThat(itemsFromRepository)
                .hasSize(2)
                .contains(listToReturn.get(0))
                .contains(listToReturn.get(1))
                .allMatch(value -> value.getName().length() > 0)
                .doesNotContain(doesNotContain);
    }
}
