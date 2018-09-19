package com.tdd.demo.services;

import com.tdd.demo.domain.Item;
import com.tdd.demo.repositories.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

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
    }
}
