package com.nia.rpc.core.utils;

/**
 * Author 卡卡
 * Created by jing on 2017/3/27.
 */
public interface Constant {
    int ZK_SESSION_TIMEOUT = 5000;
    int MAX_FRAME_LENGTH = 1024 * 1024;  //1MB

    String ZK_REGISTRY_PATH = "/registry";
    String ZK_DATA_PATH = ZK_REGISTRY_PATH + "/services/";
}
