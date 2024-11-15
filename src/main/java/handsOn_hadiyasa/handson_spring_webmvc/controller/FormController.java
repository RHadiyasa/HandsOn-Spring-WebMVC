package handsOn_hadiyasa.handson_spring_webmvc.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FormController {

    // Kalau dibuka di web akan error, karena methodnya POST sedangkan dari web kita mintanya GET
    @PostMapping(path = "/form/hello",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String hello(@RequestParam(name = "name") String name){
        return """
                <html>
                <body>
                <h1>Hello $name</h1>
                </body>
                </html>
                """.replace("$name", name);
    }

    @GetMapping("/form/hello")
    @ResponseBody
    public String helloGet(@RequestParam(name = "name") String name) {
        return "Hello " + name;
    }

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    // Kalau mau POST di postman maka consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE nya di hapus aja
    @PostMapping(path = "/form/persons")
    @ResponseBody
    public String createPerson(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "birthDate") Date birthDate,
            @RequestParam(name = "address") String address
    ){
        return "Success create person with name: " + name +
                ", birthDate: " + simpleDateFormat.format(birthDate) +
                ", address: " + address;
    }
}
