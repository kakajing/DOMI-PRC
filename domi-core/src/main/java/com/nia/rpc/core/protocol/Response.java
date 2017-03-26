package com.nia.rpc.core.protocol;

import lombok.Getter;
import lombok.Setter;

/**
 * Author 卡卡
 * Created by jing on 2017/3/26.
 */
@Getter
@Setter
public class Response {
    private long requestId;
    private Object response;
    private Throwable throwable;
}
