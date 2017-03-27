package com.nia.rpc.core.client;

import com.nia.rpc.core.protocol.Response;

import java.lang.reflect.Method;

/**
 * 服务的发现与使用
 *
 * Author 卡卡
 * Created by jing on 2017/3/27.
 */
public interface Client {
    Response sendMessage(Class<?> clazz, Method method, Object[] args);
    <T> T proxyInterface(Class<T> serviceInterface);
    void close();
}
