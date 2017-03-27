package com.nia.rpc.core.rpcproxy;

import com.nia.rpc.core.client.Client;

/**
 * Author 卡卡
 * Created by jing on 2017/3/27.
 */
public interface RpcProxy {
    <T> T proxyInterface(Client client, final Class<T> serviceInterface);
}
