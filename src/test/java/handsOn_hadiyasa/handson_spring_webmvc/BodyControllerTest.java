package handsOn_hadiyasa.handson_spring_webmvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import handsOn_hadiyasa.handson_spring_webmvc.model.request.HelloRequest;
import handsOn_hadiyasa.handson_spring_webmvc.model.response.HelloResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.MockMvcBuilder.*; // Untuk builder MockMVC
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; // untuk membuat HTTP request
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*; // Untuk logging hasil
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; // Untuk memeriksa hasil request


@SpringBootTest
@AutoConfigureMockMvc
public class BodyControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void bodyHelloTest() throws Exception {
        HelloRequest request = new HelloRequest();
        request.setName("Rafi");

        String requestJson = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                post("/body/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpectAll(
                status().isAccepted(),
                header().string(HttpHeaders.CONTENT_TYPE, Matchers.containsString(MediaType.APPLICATION_JSON_VALUE))
        ).andExpect(result -> {
            String responseJson = result.getResponse().getContentAsString();

            HelloResponse response = objectMapper.readValue(responseJson, HelloResponse.class);
            Assertions.assertEquals("Rafi", response.getName());
        });
    }
}
