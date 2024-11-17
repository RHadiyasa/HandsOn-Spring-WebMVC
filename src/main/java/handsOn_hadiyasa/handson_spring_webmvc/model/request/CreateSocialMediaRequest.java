package handsOn_hadiyasa.handson_spring_webmvc.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSocialMediaRequest {
    private String username;
    private String platform;
}
