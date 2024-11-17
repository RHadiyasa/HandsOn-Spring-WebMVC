package handsOn_hadiyasa.handson_spring_webmvc.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private CreateAddressRequest address; // Nested attribute from createAddressRequest

    private List<String> hobbies;
    private List<CreateSocialMediaRequest> socialMedia;
}
