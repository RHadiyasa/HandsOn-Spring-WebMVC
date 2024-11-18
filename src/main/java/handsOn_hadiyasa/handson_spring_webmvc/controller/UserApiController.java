package handsOn_hadiyasa.handson_spring_webmvc.controller;

import handsOn_hadiyasa.handson_spring_webmvc.model.request.CreateUserRequest;
import handsOn_hadiyasa.handson_spring_webmvc.model.response.CreateUserResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class UserApiController {


    /** Ini akan mengembalikan semua fields yang ada di CreateUserRequest*/
    @PostMapping(path = "/api/userRequest",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserRequest createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        return createUserRequest;
    }

    /** Hanya mengembalikan response berdasarkan field yang ada di createUserResponse */
    @PostMapping(path = "/api/userResponse",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserResponse createUserResponse(@RequestBody @Valid CreateUserRequest createUserRequest) {
        CreateUserResponse userResponse = new CreateUserResponse();
        userResponse.setFirstName(createUserRequest.getFirstName());
        userResponse.setLastName(createUserRequest.getLastName());
        userResponse.setMessage("User created successfully!");

        return userResponse;
    }

}
