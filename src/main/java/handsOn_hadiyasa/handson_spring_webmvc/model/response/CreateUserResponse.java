package handsOn_hadiyasa.handson_spring_webmvc.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {
    private String firstName;
    private String lastName;
    private String message;
}
