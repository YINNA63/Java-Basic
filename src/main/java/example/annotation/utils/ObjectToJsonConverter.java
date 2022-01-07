package example.annotation.utils;

import example.annotation.annotation.Init;
import example.annotation.annotation.JsonElement;
import example.annotation.annotation.JsonSerializable;
import exception.CoreException;
import exception.ExceptionType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;

/**
 * @author Nana
 * @date 2022/1/7
 */
public class ObjectToJsonConverter {

    public String convertToJson(Object object) throws CoreException {
        try {
            checkIfSerializable(object);
            initializeObject(object);
            return getJsonString(object);
        } catch (Exception e) {
            throw CoreException.of(ExceptionType.JsonSerializationException, e.getMessage());
        }
    }

    private void checkIfSerializable(Object object) {
        if (Objects.isNull(object)) {
            throw CoreException.of(ExceptionType.JsonSerializationException,
                    "The object to serialize is null");
        }

        Class<?> clazz = object.getClass();
        if (!clazz.isAnnotationPresent(JsonSerializable.class)) {
            String errMsg = "The class "
                    + clazz.getSimpleName()
                    + " is not annotated with JsonSerializable";
            throw CoreException.of(ExceptionType.JsonSerializationException, errMsg);
        }
    }

    private void initializeObject(Object object)
            throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Init.class)) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    private String getJsonString(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        Map<String, String> jsonElementsMap = new HashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonElement.class)) {
                jsonElementsMap.put(getKey(field), (String) field.get(object));
            }
        }

        String jsonString = jsonElementsMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\""
                        + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + jsonString + "}";
    }

    private String getKey(Field field) {
        String key = field.getAnnotation(JsonElement.class).key();
        return StringUtils.isEmpty(key) ? field.getName() : key;
    }
}
