package handsOn_hadiyasa.handson_spring_webmvc;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.MockMvcBuilder.*; // Untuk builder MockMVC
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; // untuk membuat HTTP request
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*; // Untuk logging hasil
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; // Untuk memeriksa hasil request

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void loginTest() throws Exception {
        mockMvc.perform(
                post("/auth/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username","rhadiyasa")
                        .param("password", "password")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("OK"))
        );
    }

    @Test
    void loginUnauthorized() throws Exception {
        mockMvc.perform(
                post("/auth/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username","rhadiyasa")
                        .param("password", "salah")
        ).andExpectAll(
                status().isUnauthorized(),
                content().string(Matchers.containsString("Not authorized"))
        );
    }
}
