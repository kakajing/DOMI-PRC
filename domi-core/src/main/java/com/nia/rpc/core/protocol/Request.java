package com.nia.rpc.core.protocol;

import lombok.Data;

/**
 * Author 卡卡
 * Created by jing on 2017/3/26.
 */
@Data
public class Request {
    private long requestId;
    private Class<?> clazz;
    private String method;
    private Class<?>[] parameterTypes;
    private Object[] params;
    private long requestTime;

}
