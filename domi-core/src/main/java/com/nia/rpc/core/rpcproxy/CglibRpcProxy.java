package com.nia.rpc.core.rpcproxy;

import com.nia.rpc.core.client.Client;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author 卡卡
 * Created by jing on 2017/3/27.
 */
public class CglibRpcProxy implements RpcProxy {

    @Override
    public <T> T proxyInterface(Client client, Class<T> serviceInterface) {
        return null;
    }

    /**
     * 搞个静态内部类来做Method的cglib代理
     */
    private static class CglibInteceptor implements MethodInterceptor {

        //首先判断所要代理的方法是通用方法，是的话就此返回此代理对象的相关内容
        private static Method hashCodeMethod;
        private static Method equalsMethod;
        private static Method toStringMethod;

        static {

        }

        /**
         * 针对这几个方法做响应的策略
         * @param proxy
         * @return
         */
        private int proxyHashCode(Object proxy){
            return System.identityHashCode(proxy);
        }

        private boolean proxyEquals(Object proxy, Object other){
            return (proxy == other);
        }

        private String proxyToString(Object proxy){
            return proxy.getClass().getName() + '@' + Integer.toHexString(proxy.hashCode());
        }

        /**
         * 加入rpc客户端和传入所调用服务的接口
         */
        private Client client;
        private Class<?> serviceInterface;

        public CglibInteceptor(Client client, Class<?> serviceInterface) {
            this.client = client;
            this.serviceInterface = serviceInterface;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {

            //先对方法进行判断是否是通用方法，假如都不是，最后再通过client来调用
            if (hashCodeMethod.equals(method)){
                return proxyHashCode(proxy);
            }
            if (equalsMethod.equals(method)){
                return proxyEquals(proxy, args[0]);
            }
            if (toStringMethod.equals(method)){
                return proxyToString(proxy);
            }
            return client.sendMessage(serviceInterface, method, args).getResponse();
        }
    }

}
