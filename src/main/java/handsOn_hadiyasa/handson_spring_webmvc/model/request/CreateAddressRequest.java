package handsOn_hadiyasa.handson_spring_webmvc.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddressRequest {
    private String street;
    private String city;
    private String province;
    private String state;
}
