package net.javaguides.springboot.util;

import org.springframework.stereotype.Component;

@Component
public class StandardResponse {
    private int code;
    private String message;
    private Object content;

    public StandardResponse(int code, String message, Object content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public StandardResponse() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
