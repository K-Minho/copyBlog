package shop.mtcoding.blog.handler.ex;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomApiException extends RuntimeException {

    private HttpStatus status;

    public CustomApiException(String msg) {
        super(msg);
        this.status = HttpStatus.BAD_REQUEST;
    }

    public CustomApiException(String msg, HttpStatus status) {
        super(msg);
        this.status = status;
    }
}
