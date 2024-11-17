package handsOn_hadiyasa.handson_spring_webmvc.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloResponse {
    private String name;
    private String message;
}
