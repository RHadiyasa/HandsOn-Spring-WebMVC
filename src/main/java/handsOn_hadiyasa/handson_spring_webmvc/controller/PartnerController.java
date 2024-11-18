package handsOn_hadiyasa.handson_spring_webmvc.controller;

import handsOn_hadiyasa.handson_spring_webmvc.entity.Partner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PartnerController {

    @GetMapping(path = "/partner/current")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String getPartner(Partner partner) {
        return partner.getId() + " : " + partner.getName();
    }
}
