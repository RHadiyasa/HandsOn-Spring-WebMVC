package handsOn_hadiyasa.handson_spring_webmvc;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.springframework.test.web.servlet.MockMvcBuilder.*; // Untuk builder MockMVC
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; // untuk membuat HTTP request
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*; // Untuk logging hasil
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; // Untuk memeriksa hasil request

@SpringBootTest
@AutoConfigureMockMvc
public class UploadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void uploadFile() throws Exception {
        mockMvc.perform(
                        multipart("/upload/image")
                                .file(new MockMultipartFile(
                                        "image",
                                        "rafi.png",
                                        "image/png",
                                        getClass().getResourceAsStream("/image/rafi.png")
                                ))
                                .param("name", "rafi")
                                .contentType(MediaType.MULTIPART_FORM_DATA)
                )
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Success save profiles rafi with files upload/rafi.png"))
                );
    }
}
