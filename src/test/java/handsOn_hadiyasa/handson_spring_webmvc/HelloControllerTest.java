package handsOn_hadiyasa.handson_spring_webmvc;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Static import needed
 * Karena banyak method yang dibutuhkan dari package tersebut
 * */
import static org.springframework.test.web.servlet.MockMvcBuilder.*; // Untuk builder MockMVC
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; // untuk membuat HTTP request
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*; // Untuk logging hasil
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; // Untuk memeriksa hasil request

/**
 * Anotasi @AutoConfigureMockMvc mengaktifkan dan menyediakan MockMvc,
 * alat untuk melakukan pengujian terhadap endpooint web Spring MVC
 * */
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    // Dependency MockMvc akan diinject oleh Spring melalui Autowired
    @Autowired
    private MockMvc mockMvc;

    /**
     * Ada banyak cara menggunakan MockMVC
     * */

    @Test
    void helloGuest() throws Exception {
        /// Melakukan request GET ke endpoint "/hello"
        mockMvc.perform(get("/hello"))
                .andExpectAll(
                        status().isOk(), /// Memastikan HTTP status adalah 200 OK
                        content().string(Matchers.containsString("Hello Guest")) /// Memastikan responsnya "Hello Guest"
                );
    }

    @Test
    void helloName() throws Exception {
        /// Melakukan request GET ke endpoint "/hello" dengan query parameter "name=Rafi"
        mockMvc.perform(get("/hello").queryParam("name", "Rafi"))
                .andExpectAll(
                        status().isOk(), /// Memastika HTTP status adalah 200 OK
                        content().string(Matchers.containsString("Hello Rafi")) /// memastikan responnya "Hello Rafi"
                );
    }
}
