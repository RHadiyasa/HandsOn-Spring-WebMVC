package handsOn_hadiyasa.handson_spring_webmvc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

/**
 * Kita tidak lagi menggunakan mockMvc karena akan benar benar menggunakan HTTP asli
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIntegrationTest {

    /// untuk mengetahui port mana yang digunakan
    @LocalServerPort
    private Integer port;

    /// HTTP client yang digunakan untuk memanggil web/client yang kita buat
    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Karena tidak menggunakan MockMvc lagi, jadi kita benar benar mengirim request ke aplikasi web
     * */

    @Test
    void helloGuest(){
        String response = restTemplate.getForEntity("http://localhost:" + port + "/hello", String.class).getBody();
        Assertions.assertNotNull(response); // Memastikan bahwa response yang diterima tidak null
        Assertions.assertEquals("Hello Guest", response.trim());
    }

    @Test
    void helloUser(){
        String response = restTemplate.getForEntity("http://localhost:" + port + "/hello?name=User", String.class).getBody();
        Assertions.assertNotNull(response); // Memastikan bahwa response yang diterima tidak null
        Assertions.assertEquals("Hello User", response.trim());
    }
}
