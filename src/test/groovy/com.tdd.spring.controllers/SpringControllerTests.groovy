import com.tdd.spring.controllers.SpringController
import com.tdd.spring.services.ItemBusinessService
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@Unroll
class SpringControllerTests extends Specification {

    MockMvc mockMvc
    SpringController springController

    void setup() {
        springController = new SpringController(
                itemBusinessService: Mock(ItemBusinessService)
        )
        mockMvc = MockMvcBuilders.standaloneSetup(springController).build()
    }

    def 'should return a valid status and report Hello World!'() {

        when:
        def response = mockMvc
                .perform(get("/foo/bar")
                .accept(MediaType.APPLICATION_JSON))

        then:
        response.andExpect(status().isOk())
                .andExpect(content().string("Hello World!"))
    }

}