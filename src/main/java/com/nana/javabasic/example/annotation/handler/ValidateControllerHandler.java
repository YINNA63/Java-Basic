package com.nana.javabasic.example.annotation.handler;

import com.nana.javabasic.example.annotation.annotation.ValidateAnnotation;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 校验的注解处理器
 *
 * @author Nana
 * @date 2022/1/7
 */
@Slf4j
@Aspect
@Component // This @Component is required in spring aop
public class ValidateControllerHandler {

    // Spring and its quirks. The aspect interface name will work if the aspect has no parameters,
    // but should be changed to parameter name if aspect has parameters
    @Around(" @annotation(annotation)")
    public Object validate(ProceedingJoinPoint pjp, ValidateAnnotation annotation) throws Throwable {
        // some validate logic
        log.info("this is validating @ValidateAnnotation");
        HttpServletRequest req = getRequest();
        // Check header values
        // Throw Spring's AccessDeniedException if needed
        return pjp.proceed();
    }

    private HttpServletRequest getRequest() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return sra.getRequest();
    }
}
