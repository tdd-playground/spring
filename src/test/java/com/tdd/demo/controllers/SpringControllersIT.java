package com.tdd.demo.controllers;

import com.tdd.demo.domain.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


// Launches entire Spring Boot application with SpringBootTest, and in-memory database
// Annotation that can be specified on a test class that runs Spring Boot based tests. Provides the following features over and above the regular Spring TestContext Framework:
// - Uses SpringBootContextLoader as the default ContextLoader when no specific @ContextConfiguration(loader=...) is defined.
// - Automatically searches for a @SpringBootConfiguration when nested @Configuration is not used, and no explicit classes are specified.
// - Allows custom Environment properties to be defined using the properties attribute.
// - Provides support for different webEnvironment modes, including the ability to start a fully running web server listening on a defined or random port.
// - Registers a TestRestTemplate and/or WebTestClient bean for use in web tests that are using a fully running web server.
@RunWith(SpringRunner.class)
// DEFINED_PORT - Creates a (reactive) web application context without defining any server.port=0 Environment property.
// MOCK - Creates a WebApplicationContext with a mock servlet environment if servlet APIs are on the classpath, a ReactiveWebApplicationContext if Spring WebFlux is on the classpath or a regular ApplicationContext otherwise.
// NONE - Creates an ApplicationContext and sets SpringApplication.setWebApplicationType(WebApplicationType) to WebApplicationType.NONE.
// RANDOM_PORT - Creates a web application context (reactive or servlet based) and sets a server.port=0 Environment property (which usually triggers listening on a random port).
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Don't use same port as Spring Boot Application
public class SpringControllersIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception {
        String result = this.restTemplate.getForObject("/foo/items", String.class);
        JSONAssert.assertEquals("[{id: 1},{id: 2},{id: 3},{id: 4}]", result, false);
    }
}
