package example.annotation.interceptor;

import example.annotation.annotation.CustomControllerAnnotation;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 自定义解释器
 *
 * @author Nana
 * @date 2022/1/7
 */
@Slf4j
public class CustomInterceptor extends HandlerInterceptorAdapter {

//    @Resource
//    SomeManager manager;

    // preHandle 是在进入该请求方法体之前的操作，其他还有 postHandle/afterCompletion/afterConcurrentHandlingStarted
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        this.customAnnotationHandler((HandlerMethod) handler, params);

        return super.preHandle(request, response, handler);
    }

    // 此处 handlerMethod 即为请求的接口方法
    private void customAnnotationHandler(HandlerMethod handlerMethod, Integer params) {
        CustomControllerAnnotation methodAnnotation = handlerMethod.getMethodAnnotation(
                CustomControllerAnnotation.class);
        CustomControllerAnnotation controllerAnnotation = handlerMethod.getMethod().getDeclaringClass().getAnnotation(
                CustomControllerAnnotation.class);


        if(Objects.nonNull(methodAnnotation)) {
            log.info("detect method annotation of type " + CustomControllerAnnotation.class.getName() + " from method " + handlerMethod.toString());
        }

        if(Objects.nonNull(controllerAnnotation)) {
            log.info("detect controller annotation of type " + CustomControllerAnnotation.class.getName() + " from controller " + handlerMethod.getClass().getName());
        }
//        if(!manager.valid(params)) {
//            throw SomeException;
//        } else {
//            manager.doSomething();
//        }
    }
}
