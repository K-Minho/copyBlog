package shop.mtcoding.blog.handler.ex;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private HttpStatus status;

    public CustomException(String msg) {
        super(msg);
        this.status = HttpStatus.BAD_REQUEST;
    }

    public CustomException(String msg, HttpStatus status) {
        super(msg);
        this.status = status;
    }
}
