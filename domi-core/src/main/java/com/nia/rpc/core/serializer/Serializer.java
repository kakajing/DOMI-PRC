package com.nia.rpc.core.serializer;

/**
 * Author 卡卡
 * Created by jing on 2017/3/26.
 */
public interface Serializer {
    byte[] serialize(Object obj);
    <T> T deserialize(byte[] bytes);
}
