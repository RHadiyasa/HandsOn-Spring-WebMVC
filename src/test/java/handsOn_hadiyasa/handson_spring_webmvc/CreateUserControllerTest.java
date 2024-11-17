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
public class CreateUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createUserTest() throws Exception {
        mockMvc.perform(
                post("/new/user")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", "rafi")
                        .param("lastName", "hadiyasa")
                        .param("email", "rafi@gmail.com")
                        .param("phone", "089123456789")
                        .param("address.street", "Meteo")
                        .param("address.city", "Jakarta Selatan")
                        .param("address.province", "DKI Jakarta")
                        .param("address.state", "Indonesia")
                        .param("hobbies[0]", "Coding")
                        .param("hobbies[1]", "Singing")
                        .param("socialMedia[0].username", "mrhadiyasa")
                        .param("socialMedia[0].platform", "Instagram")
                        .param("socialMedia[1].username", "heisenberg")
                        .param("socialMedia[1].platform", "Twitter")
        ).andExpectAll(
                status().isCreated(),
                content()
                        .string(Matchers
                                .containsString("Success Create User rafi hadiyasa with email rafi@gmail.com and phone 089123456789 | Address Meteo, Jakarta Selatan, DKI Jakarta, Indonesia | Social Media : [mrhadiyasa/Instagram, heisenberg/Twitter] | Hobbies : [Coding, Singing]")
                        ));
    }
}
