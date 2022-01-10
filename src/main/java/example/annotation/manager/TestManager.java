package example.annotation.manager;

import example.annotation.annotation.ValidateAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Nana
 * @date 2022/1/8
 */
@Slf4j
@Component
public class TestManager {

    @ValidateAnnotation
    public void test() {
        log.info("this is test().");
    }
}
