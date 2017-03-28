package com.nia.rpc.core.exception;

/**
 * Author 卡卡
 * Created by jing on 2017/3/29.
 */
public class RequestTimeoutException extends RuntimeException {

    public RequestTimeoutException(String message) {
        super(message);
    }

    public RequestTimeoutException(Throwable cause) {
        super(cause);
    }
}
