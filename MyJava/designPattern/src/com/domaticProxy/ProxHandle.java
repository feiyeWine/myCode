package com.domaticProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxHandle implements InvocationHandler{
    private RealStar real;
    public ProxHandle(RealStar real){
	this.real = real;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
	    throws Throwable {
	Object obj = null;
	System.out.println("��̬���ɴ�����");
	obj = method.invoke(real, args);
	
	return obj;
    }
}
