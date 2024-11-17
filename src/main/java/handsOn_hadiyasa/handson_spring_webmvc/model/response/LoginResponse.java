package handsOn_hadiyasa.handson_spring_webmvc.model.response;

import jakarta.servlet.http.Cookie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String username;
    private String token;
    private Cookie cookie;
}
