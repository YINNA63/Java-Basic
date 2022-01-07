package exception;

/**
 * 异常类
 *
 * @author Nana
 * @date 2022/1/7
 */
public class CoreException extends RuntimeException {

    private ExceptionType exceptionType;

    private String message;

    public CoreException(String message) {
        this.message = message;
    }

    public CoreException(ExceptionType exceptionType, String message) {
        this.message = message;
        this.exceptionType = exceptionType;
    }

    public static CoreException of(ExceptionType exceptionType, String message) {
        return new CoreException(exceptionType, message);
    }
}
