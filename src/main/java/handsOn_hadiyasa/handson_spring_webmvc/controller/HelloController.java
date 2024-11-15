package handsOn_hadiyasa.handson_spring_webmvc.controller;

import handsOn_hadiyasa.handson_spring_webmvc.service.HelloService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Objects;

@Controller // Otomatis menjadi bean
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(path = "/hello")
    public void helloWorld(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String name = request.getParameter("name");
        String stringResponse = helloService.hello(name);
        /*if (Objects.isNull(name)) {
            name = "Guest";
        }*/
        response.getWriter().println(stringResponse);
    }
}
