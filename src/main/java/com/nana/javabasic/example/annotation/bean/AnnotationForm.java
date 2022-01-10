package com.nana.javabasic.example.annotation.bean;

import com.nana.javabasic.example.annotation.annotation.NoWhitespace;
import lombok.Data;

/**
 * 校验表单
 *
 * @author Nana
 * @date 2022/1/10
 */
@Data
public class AnnotationForm {

    @NoWhitespace(message = "不能含有空格")
    private String string;
}
