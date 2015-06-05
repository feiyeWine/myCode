package com.staticProxy;

public class ProxyStar implements Star{
    private RealStar star;
    public ProxyStar(RealStar star){
	this.star = star;
    }
    @Override
    public void request() {
	System.out.println("ProxyStar.request()");
    }

    @Override
    public void handle() {
	star.handle();
    }

    @Override
    public void response() {
	System.out.println("ProxyStar.response()");
    }

}
