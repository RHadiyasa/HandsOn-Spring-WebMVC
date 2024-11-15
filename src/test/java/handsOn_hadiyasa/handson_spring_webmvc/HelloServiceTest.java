package handsOn_hadiyasa.handson_spring_webmvc;

import handsOn_hadiyasa.handson_spring_webmvc.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    void testHello(){
        assertEquals("Hello Guest", helloService.hello(null));
        assertEquals("Hello User", helloService.hello("User"));
    }

    /**
     * Mock Bean
     *
     * */
}
