package handsOn_hadiyasa.handson_spring_webmvc.controller;

import handsOn_hadiyasa.handson_spring_webmvc.entity.LoggedInUser;
import handsOn_hadiyasa.handson_spring_webmvc.exception.CustomException;
import handsOn_hadiyasa.handson_spring_webmvc.model.request.LoginRequest;
import handsOn_hadiyasa.handson_spring_webmvc.model.response.LoginResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @PostMapping(path = "/auth/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password
    ) {
        if ("rhadiyasa".equals(username) && "password".equals(password)) {
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not authorized", HttpStatus.UNAUTHORIZED);
        }
    }

    /** -------------------------------------- */

    @PostMapping(path = "/auth/v2/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> loginUser(
            @RequestBody LoginRequest loginRequest,
            HttpServletResponse httpServletResponse,
            HttpServletRequest httpServletRequest
    ) {
        if ("rhadiyasa".equals(loginRequest.getUsername()) && "password".equals(loginRequest.getPassword())) {

            HttpSession session = httpServletRequest.getSession(true);
            session.setAttribute("username", new LoggedInUser(loginRequest.getUsername()));

            Cookie cookie = new Cookie("username", loginRequest.getUsername());
            cookie.setPath("/");
            httpServletResponse.addCookie(cookie);

            LoginResponse response = new LoginResponse();
            response.setUsername(loginRequest.getUsername());
            response.setToken("GeneratedTokenXYZ");
            response.setCookie(cookie);

            return ResponseEntity.ok(response);
        } else {
            CustomException customException = new CustomException(
                    HttpStatus.UNAUTHORIZED.value(),
                    "Invalid login"
            );

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(customException);
        }
    }
}
