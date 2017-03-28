package com.nia.rpc.factory;

import com.nia.rpc.core.bootstrap.ClientBuider;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * Author 卡卡
 * Created by jing on 2017/3/29.
 */
@Data
public class ClientFactoryBean<T> implements FactoryBean<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientFactoryBean.class);

    private Class<T> serviceInterface;
    private String serviceName;
    private String zkConn;


    @Override
    public T getObject() throws Exception {
        return ClientBuider.<T>buider()
                .zkConn(zkConn)
                .serviceName(serviceName)
                .serviceInterface(serviceInterface)
                .bulid();
    }

    @Override
    public Class<?> getObjectType() {
        return serviceInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
