package handsOn_hadiyasa.handson_spring_webmvc.service.implementation;

import handsOn_hadiyasa.handson_spring_webmvc.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        if (name == null){
            return "Hello Guest";
        } else {
            return "Hello " + name;
        }
    }
}
