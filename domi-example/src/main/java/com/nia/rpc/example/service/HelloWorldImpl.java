package com.nia.rpc.example.service;

/**
 * Author 卡卡
 * Created by jing on 2017/3/29.
 */
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String say(String hello) {
        return "server: " + hello;
    }

    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int max(Integer a, Integer b) {
        return a <= b ? b : a;
    }
}
