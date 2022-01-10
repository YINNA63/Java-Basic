package controller;

import example.annotation.annotation.CustomControllerAnnotation;
import example.annotation.annotation.ValidateAnnotation;
import javax.xml.ws.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自定义 API 入口
 *
 * @author Nana
 * @date 2022/1/7
 */
@RestController
@RequestMapping("/api/example/annotation")
public class CustomController {

    @CustomControllerAnnotation
    @GetMapping("/custom-annotation")
    public Response<Object> get() {
        return null;
    }

    @ValidateAnnotation
    @GetMapping("/validate-annotation")
    public Response<Object> validate() {
        return null;
    }
}
