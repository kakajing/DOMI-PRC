package com.nia.rpc.factory;

import com.nia.rpc.core.bootstrap.ServerBuilder;
import com.nia.rpc.core.server.Server;
import com.nia.rpc.core.server.ServerImpl;
import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

/**
 * Author 卡卡
 * Created by jing on 2017/3/29.
 */
@Data
public class ServerFactoryBean implements FactoryBean<Object> {

    private Class<?> serviceInterface;
    private Object serviceImpl;
    private String ip;
    private int port;
    private String serviceName;
    private String zkConn;
    private ServerImpl rpcServer;

    //服务注册并提供
    public void start(){
        Server rpcSerer = ServerBuilder.builder()
                .serviceImpl(serviceImpl)
                .serviceName(serviceName)
                .zkConn(zkConn)
                .port(port)
                .build();
    }

    //服务下线
    public void serviceOfflin(){
        rpcServer.shutdown();
    }

    @Override
    public Object getObject() throws Exception {
        return this;
    }

    @Override
    public Class<?> getObjectType() {
        return this.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
