package com.yevhenii.to_do_list.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class NotContentException extends Exception {
    public NotContentException() {
    }
}
