package handsOn_hadiyasa.handson_spring_webmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Objects;

@Controller // Otomatis menjadi bean
public class HelloController {

    @RequestMapping(path = "/hello")
    public void helloWorld(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String name = request.getParameter("name");
        if (Objects.isNull(name)) {
            name = "Guest";
        }
        response.getWriter().println("Hello " + name);
    }
}
