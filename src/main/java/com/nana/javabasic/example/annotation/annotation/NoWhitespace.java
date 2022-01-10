package com.nana.javabasic.example.annotation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import org.apache.commons.lang.StringUtils;

/**
 * 不允许包含空格的接口参数校验注解
 * @author nana
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {NoWhitespace.IsStringNoWhitespaceHandler.class})
public @interface NoWhitespace {

    String message() default "{validation.constraints.NoWhitespace.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class IsStringNoWhitespaceHandler implements ConstraintValidator<NoWhitespace, String> {

        @Override
        public void initialize(NoWhitespace constraintAnnotation) {

        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            if (StringUtils.isBlank(value)) {
                return false;
            }
            Pattern pattern = Pattern.compile("(\\s)");
            Matcher matcher = pattern.matcher(value);
            return !matcher.find();
        }
    }
}
