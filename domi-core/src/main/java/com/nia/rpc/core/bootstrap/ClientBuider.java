package com.nia.rpc.core.bootstrap;

import com.google.common.base.Preconditions;
import com.nia.rpc.core.client.ClientImpl;
import com.nia.rpc.core.rpcproxy.CglibRpcProxy;
import com.nia.rpc.core.rpcproxy.RpcProxy;

/**
 * Author 卡卡
 * Created by jing on 2017/3/29.
 */
public class ClientBuider<T> {

    private String serviceName;
    private String zkConn;
    private Class<T> serviceInterface;
    private int requestTimeoutMillis = 10000;
    private Class<? extends RpcProxy> clientProxyClass = CglibRpcProxy.class;

    public static <T> ClientBuider<T> buider(){
        return new ClientBuider<T>();
    }

    public ClientBuider<T> serviceName(String serviceName){
        this.serviceName = serviceName;
        return this;
    }

    public ClientBuider<T> zkConn(String zkConn){
        this.zkConn = zkConn;
        return this;
    }

    public ClientBuider<T> serviceInterface(Class<T> serviceInterface){
        this.serviceInterface = serviceInterface;
        return this;
    }

    public ClientBuider<T> requestTimeout(int requestTimeoutMillis){
        this.requestTimeoutMillis = requestTimeoutMillis;
        return this;
    }

    public ClientBuider<T> clientProxyClass(Class<? extends RpcProxy> clientProxyClass){
        this.clientProxyClass = clientProxyClass;
        return this;
    }


    public T bulid(){
        //因Curator底层依赖guava，刚好可以拿来验证
        Preconditions.checkNotNull(serviceInterface);
        Preconditions.checkNotNull(zkConn);
        Preconditions.checkNotNull(serviceName);
        ClientImpl client = new ClientImpl(this.serviceName);
        client.setZkConn(this.zkConn);
        client.setRequestTimeoutMillis(this.requestTimeoutMillis);
        client.init();
        return client.proxyInterface(this.serviceInterface);
    }
}
