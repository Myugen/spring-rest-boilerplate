package ninja.mcabsan.boilerplate.error.builder;

import ninja.mcabsan.boilerplate.error.CustomException;

public class CustomExceptionBuilder {

    private Throwable cause;
    private String message;
    private String code;
    private String[] params;

    public CustomExceptionBuilder() {
    }

    public CustomExceptionBuilder cause(Throwable cause) {
        this.cause = cause;
        return this;
    }

    public CustomExceptionBuilder message(String message) {
        this.message = message;
        return this;
    }

    public CustomExceptionBuilder code(String code) {
        this.code = code;
        return this;
    }

    public CustomExceptionBuilder params(String... params) {
        this.params = params;
        return this;
    }

    public CustomException build() {
        return new CustomException(cause, message, code, params);
    }
}