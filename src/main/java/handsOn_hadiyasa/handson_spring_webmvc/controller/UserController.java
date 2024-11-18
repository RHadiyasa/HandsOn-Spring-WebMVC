package handsOn_hadiyasa.handson_spring_webmvc.controller;

import handsOn_hadiyasa.handson_spring_webmvc.entity.LoggedInUser;
import handsOn_hadiyasa.handson_spring_webmvc.model.request.CreateUserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @PostMapping(path = "/new/user",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(
            @ModelAttribute CreateUserRequest userRequest
    ) {
        return new StringBuilder().append("Success Create User ")
                .append(userRequest.getFirstName()).append(" ")
                .append(userRequest.getLastName())
                .append(" with email ").append(userRequest.getEmail())
                .append(" and phone ").append(userRequest.getPhone())
                // access createAddressRequest Attributes
                .append(" | Address ").append(userRequest.getAddress().getStreet())
                .append(", ").append(userRequest.getAddress().getCity())
                .append(", ").append(userRequest.getAddress().getProvince())
                .append(", ").append(userRequest.getAddress().getState())

                // Access socialMedia attributes
                .append(" | Social Media : ").append(userRequest
                        .getSocialMedia()
                        .stream()
                        .map(sm -> sm.getUsername() + "/" + sm.getPlatform())
                        .toList())
                .append(" | Hobbies : ").append(userRequest.getHobbies().stream().toList())
                .toString();
    }

    @GetMapping(path = "/user/current")
    @ResponseBody
    public String getCurrentUser(@SessionAttribute(name = "username") LoggedInUser loggedInUser) {
        if (loggedInUser == null) {
            return "Current user is null";
        }
        return "LoggedIn User as " + loggedInUser.getUsername();
    }
}
