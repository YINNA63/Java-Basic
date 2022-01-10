import static org.junit.Assert.assertEquals;

import com.nana.javabasic.example.annotation.manager.TestManager;
import com.nana.javabasic.example.annotation.utils.ObjectToJsonConverter;
import com.nana.javabasic.example.annotation.bean.Person;
import com.nana.javabasic.exception.CoreException;
import org.junit.Test;
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
