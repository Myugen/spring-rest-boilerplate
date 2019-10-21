package ninja.mcabsan.boilerplate.error;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
public class CustomException extends RuntimeException {
    private static final long serialVersionUID = -6459733322369346361L;

    private final ErrorVM errorVM;

    public CustomException(Throwable e, String message, String code, String... params) {
        List<String> paramsCollection = params != null ? Arrays.asList(params) : Collections.emptyList();
        errorVM = new ErrorVM(message, code, paramsCollection);
    }
}
