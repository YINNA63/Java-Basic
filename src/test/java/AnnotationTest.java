import static org.junit.Assert.assertEquals;

import example.annotation.utils.ObjectToJsonConverter;
import example.annotation.bean.Person;
import exception.CoreException;
import org.junit.Test;

/**
 * 注解相关测试
 *
 * @author Nana
 * @date 2022/1/7
 */
public class AnnotationTest {
    @Test
    public void givenObjectSerializedThenTrueReturned() throws CoreException {
        Person person = new Person("soufiane", "cheouati", "34");
        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        String jsonString = serializer.convertToJson(person);
        assertEquals(
                "{\"personAge\":\"34\",\"firstName\":\"Soufiane\",\"lastName\":\"Cheouati\"}",
                jsonString);
    }
}
