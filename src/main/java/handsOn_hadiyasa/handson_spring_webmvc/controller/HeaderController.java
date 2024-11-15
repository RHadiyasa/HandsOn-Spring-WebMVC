package handsOn_hadiyasa.handson_spring_webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HeaderController {

    @GetMapping("/header/token")
    @ResponseBody
    public String header(@RequestHeader(name = "X-TOKEN") String token) {
        if (token.equals("RAFI")) {
            return "OK";
        } else {
            return "ERROR";
        }
    }
}
