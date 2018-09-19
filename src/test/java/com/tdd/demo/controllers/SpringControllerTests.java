package com.tdd.demo.controllers;

import com.tdd.demo.domain.Item;
import com.tdd.demo.services.ItemBusinessService;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = SpringController.class, secure=false)
public class SpringControllerTests {

    @Autowired
    private MockMvc mockMvc; // WebMvcTest makes this bean available

    @MockBean // Annotation that can be used to add mocks to a Spring ApplicationContext
    private ItemBusinessService itemBusinessService;

    // Naming Convention:
    //  [UnitOfWork_StateUnderTest_ExpectedBehavior]
    //  [MethodName_StateUnderTest_ExpectedBehavior]
    // If we write tests for a single class, we should name our test methods by using this formula:
    //  [the name of the tested method]_[expected input / tested state]_[expected behavior].
    // If we write tests for a single feature, we should name our test methods by using this formula:
    //  [the name of the tested feature]_[expected input / tested state]_[expected behavior].

    @Test
    public void getHelloWorld_callToGetService_returnsHelloWorldAsString() throws Exception {

        // Configurations:
        // contextPath(..)
        // servletPath(..)
        // pathInfo(..)
        // secure(boolean)
        // characterEncoding(String encoding)
        // content(..)
        // contentType(..)
        // accept(..)
        // header(..)
        // headers(..)
        // param(..)
        // params(..)
        // cookie(..)
        // locale(..)
        // requestAttr(..)
        // sessionAttr(..)
        // sessionAttrs(..)
        // flashAttr(..)
        // session(..)
        // principal(..)

        // Builders:
        // MockMvcRequestBuilders - get()
        // MockMvcWebClientBuilder

        mockMvc.perform(get("/foo/bar")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string("Hello World!"));

        // Assertions:
        // status()
        // content()
        // header()
        // jsonPath(..)
        // xpath(..)
        // cookie()
        // request()
        // handler()
        // model()
        // view()
    }

    @Test
    public void getItem_callToGetSingleItemService_returnsSingleItem() throws Exception {
        mockMvc.perform(get("/foo/item").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().json("{ id: 123, name:\"An Item\" }")) // With json over string, much less brittle
        .andExpect(jsonPath("$.id", is(123)))
        .andExpect(jsonPath("$.name", is("An Item")));
        // hasSize(..) is for using with collections
        // Only confirms for the content you provide i.e. you could take out name and still pass.
    }

    // 	public ResultMatcher json(final String jsonContent, final boolean strict) {
    //		return result -> {
    //			String content = result.getResponse().getContentAsString();
    //			jsonHelper.assertJsonEqual(jsonContent, content, strict);
    //		};
    //	}
    // --> Uses JSONAssert framework

    @Test
    public void random_jsonAssertTest() throws JSONException {
        String actualResponse = "{ id: 123, name:\"An Item\" }"; // You don't need escape characters, ony if you have a space
        String expectedResponse = "{ id: 123 }";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
        // When strict is set to false (recommended), it forgives reordering data and extending results (as long as all the expected elements are there), making tests less brittle.
    }

    @Test
    public void getItemFromBusinessService_callToGetItem_returnSingleItem() throws Exception {
        when(itemBusinessService.getItem()).thenReturn(new Item(123, "Some Item"));

        mockMvc.perform((get("/foo/item-service")).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{ id: 123, name:\"Some Item\" }"));
    }

    @Test
    public void getAllItemsFromRepository_callToGetAllItemsFromRespository_returnAllItems() throws Exception {
        List<Item> listToReturn = Arrays.asList(
                new Item(1, "Some Item 1"),
                new Item(2, "Some Item 2")
        );
        when(itemBusinessService.getItemsFromRepository()).thenReturn(listToReturn);

        mockMvc.perform(get("/foo/items").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"Some Item 1\",\"value\":0},{\"id\":2,\"name\":\"Some Item 2\",\"value\":0}]"));
    }

    @Test
    public void samplePostService_postSomeData_printsDataToStandardOut() throws Exception {
        mockMvc.perform(post("/foo/item-update").contentType(MediaType.APPLICATION_JSON).content("{ \"id\": \"1\"}"))
        .andExpect(status().is2xxSuccessful())
        .andReturn(); // Return the result of the executed request for direct access to the results.
    }
}
