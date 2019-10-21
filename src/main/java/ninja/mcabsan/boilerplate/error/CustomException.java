package ninja.mcabsan.boilerplate.error;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class CustomException extends RuntimeException {
    private static final long serialVersionUID = -6459733322369346361L;

    private final ErrorVM errorVM;

    public CustomException(Throwable e, String message, String code, String... params) {
        errorVM = new ErrorVM(message, code, Arrays.asList(params));
    }
}
