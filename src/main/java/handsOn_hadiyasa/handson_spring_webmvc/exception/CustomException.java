package handsOn_hadiyasa.handson_spring_webmvc.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomException {
    // invalid credentials method
    private int status;
    private String message;
}
