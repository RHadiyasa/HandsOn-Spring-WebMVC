package handsOn_hadiyasa.handson_spring_webmvc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.spec.OAEPParameterSpec;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class UploadController {

    @PostMapping(path = "/upload/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public String upload(@RequestParam(name = "name") String name,
                         @RequestParam(name = "image") MultipartFile file) throws IOException {

        // membuat nama file menjadi unik
        Path path = Path.of("upload/" + file.getOriginalFilename());
        file.transferTo(path);

        // Ubah backslash menjadi slash
        String pathString = path.toString().replace("\\", "/");

        return "Success save profiles " + name + " with files " + pathString;
    }
}
