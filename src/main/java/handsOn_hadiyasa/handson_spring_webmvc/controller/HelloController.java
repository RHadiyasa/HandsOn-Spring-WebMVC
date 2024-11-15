package handsOn_hadiyasa.handson_spring_webmvc.controller;

import handsOn_hadiyasa.handson_spring_webmvc.service.HelloService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Objects;

@Controller // Otomatis menjadi bean
public class HelloController {
    /**
     * Macam-macam annotation:
     * 1. GET       -> @GetMapping
     * 2. POST      -> @PostMapping
     * 3. PUT       -> @PutMapping
     * 4. PATCH     -> @PatchMapping
     * 5. DELETE    -> @DeleteMapping
     */

    @Autowired
    private HelloService helloService;

    /// Kalau menggunakan @GetMapping tidak perlu lagi menuliskan "method = RequestMethod.GET"
    @GetMapping(path = "/hello")
    public void helloWorld(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String name = request.getParameter("name");
        String stringResponse = helloService.hello(name);
        /*if (Objects.isNull(name)) {
            name = "Guest";
        }*/
        response.getWriter().println(stringResponse);
    }

    /**
     * Annotation @RequestParam digunakan untuk memberitahu bahwa kita membutuhkan request parameter
     * */

    @GetMapping(path = "/profile")
    public void profile(@RequestParam(name = "name", required = false) String name, HttpServletResponse response) throws IOException {
        String responseBody = helloService.hello(name);
        response.getWriter().println(responseBody);
    }
}
