package handsOn_hadiyasa.handson_spring_webmvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import handsOn_hadiyasa.handson_spring_webmvc.model.request.HelloRequest;
import handsOn_hadiyasa.handson_spring_webmvc.model.response.HelloResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class BodyController {

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(path = "/body/hello",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String body(@RequestBody String body) throws JsonProcessingException {
        HelloRequest helloRequest = objectMapper.readValue(body, HelloRequest.class);

        HelloResponse response = new HelloResponse();
        response.setName(helloRequest.getName());
        response.setMessage("Hello " + helloRequest.getName());

        return objectMapper.writeValueAsString(response);
    }
}
