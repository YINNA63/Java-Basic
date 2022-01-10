import static org.junit.Assert.assertEquals;

import example.annotation.annotation.ValidateAnnotation;
import example.annotation.manager.TestManager;
import example.annotation.utils.ObjectToJsonConverter;
import example.annotation.bean.Person;
import exception.CoreException;
import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * 注解相关测试
 *
 * @author Nana
 * @date 2022/1/7
 */
@Component
public class AnnotationTest {

//    @Autowired
    TestManager testManager = new TestManager();

    @Test
    public void givenObjectSerializedThenTrueReturned() throws CoreException {
        Person person = new Person("soufiane", "cheouati", "34");
        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        String jsonString = serializer.convertToJson(person);
        assertEquals(
                "{\"personAge\":\"34\",\"firstName\":\"Soufiane\",\"lastName\":\"Cheouati\"}",
                jsonString);
    }

    @Test
    public void validate() {
        testManager.test();
    }
}
