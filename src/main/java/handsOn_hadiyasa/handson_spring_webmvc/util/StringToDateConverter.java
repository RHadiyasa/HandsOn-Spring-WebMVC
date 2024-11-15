package handsOn_hadiyasa.handson_spring_webmvc.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class StringToDateConverter implements Converter<String, Date> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Parameter yang digunakan

    @Override
    public Date convert(String source) {
        try{
            return dateFormat.parse(source);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }
}
