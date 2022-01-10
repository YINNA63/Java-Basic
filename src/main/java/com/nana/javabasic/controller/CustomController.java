package com.nana.javabasic.controller;

import com.nana.javabasic.example.annotation.annotation.CustomControllerAnnotation;
import com.nana.javabasic.example.annotation.annotation.NoWhitespace;
import com.nana.javabasic.example.annotation.annotation.ValidateAnnotation;
import com.nana.javabasic.example.annotation.bean.AnnotationForm;
import javax.validation.Valid;
import javax.xml.ws.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/validator")
    public Response validateWhitespace(
            @NoWhitespace @RequestParam String field,
            @Valid @RequestBody AnnotationForm form
    ) throws Exception {
        return null;
    }
}
