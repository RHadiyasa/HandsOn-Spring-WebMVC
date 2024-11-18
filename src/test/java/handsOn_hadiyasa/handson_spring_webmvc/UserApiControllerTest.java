package handsOn_hadiyasa.handson_spring_webmvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import handsOn_hadiyasa.handson_spring_webmvc.model.request.CreateSocialMediaRequest;
import handsOn_hadiyasa.handson_spring_webmvc.model.request.CreateUserRequest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; // untuk membuat HTTP request
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; // Untuk memeriksa hasil request


import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class UserApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createUser() throws Exception {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstName("Rafi");
        createUserRequest.setLastName("Hadiyasa");
        createUserRequest.setEmail("rafihadiyasa@gmail.com");
        createUserRequest.setPhone("089123456789");
        createUserRequest.setHobbies(List.of("Coding","Reading"));
        createUserRequest.setSocialMedia(new ArrayList<>());
        createUserRequest.getSocialMedia().add(new CreateSocialMediaRequest("rhadiyasa","Instagram"));
        createUserRequest.getSocialMedia().add(new CreateSocialMediaRequest("heisenberg","Twitter"));

        String jsonFormat = objectMapper.writeValueAsString(createUserRequest);

        mockMvc.perform(
                post("/api/userRequest")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonFormat)
        ).andExpectAll(
                status().isCreated(),
                content().json(jsonFormat)
        );

        // cek isi json
        System.out.println(jsonFormat);
    }

    @Test
    void createUserError() throws Exception {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstName("Rafi");
        createUserRequest.setLastName("Hadiyasa");
        createUserRequest.setHobbies(List.of("Coding","Reading"));
        createUserRequest.setSocialMedia(new ArrayList<>());
        createUserRequest.getSocialMedia().add(new CreateSocialMediaRequest("rhadiyasa","Instagram"));
        createUserRequest.getSocialMedia().add(new CreateSocialMediaRequest("heisenberg","Twitter"));

        String jsonFormat = objectMapper.writeValueAsString(createUserRequest);

        mockMvc.perform(
                post("/api/userRequest")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonFormat)
        ).andExpectAll(
                status().isBadRequest(),
                content().string(Matchers.containsString("Method argument is invalid"))
        );

        // cek isi json
        System.out.println(jsonFormat);
    }

    @Test
    void createUserErrorBinding() throws Exception {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstName("Rafi");
        createUserRequest.setLastName("Hadiyasa");
        createUserRequest.setHobbies(List.of("Coding","Reading"));
        createUserRequest.setSocialMedia(new ArrayList<>());
        createUserRequest.getSocialMedia().add(new CreateSocialMediaRequest("rhadiyasa","Instagram"));
        createUserRequest.getSocialMedia().add(new CreateSocialMediaRequest("heisenberg","Twitter"));

        String jsonFormat = objectMapper.writeValueAsString(createUserRequest);

        mockMvc.perform(
                post("/api/userResponse")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonFormat)
        ).andExpectAll(
                status().isBadRequest(),
                content().string(Matchers.containsString("Invalid Data"))
        );

        // cek isi json
        System.out.println(jsonFormat);
    }

    @Test
    void getUserInvalid() throws Exception {
        mockMvc.perform(
                get("/user/current")
        ).andExpectAll(
                status().is3xxRedirection()
        );
    }
}
