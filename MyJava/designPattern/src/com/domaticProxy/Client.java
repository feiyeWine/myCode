package com.domaticProxy;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
	RealStar real = new RealStar();
	ProxHandle handle = new ProxHandle(real);
	Star prox = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader()
		,new Class[]{Star.class}, handle);
	prox.handle();
    }
}
