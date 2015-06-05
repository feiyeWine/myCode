package com.domaticProxy;

public class RealStar implements Star{

    @Override
    public void request() {
	System.out.println("RealStar.request()");
    }

    @Override
    public void handle() {
	System.out.println("RealStar.handle()");
    }

    @Override
    public void response() {
	System.out.println("RealStar.response()");
    }
}
