package com.staticProxy;

public class Client {
    public static void main(String[] args) {
	RealStar real = new RealStar();
	ProxyStar proxy = new ProxyStar(real);
	proxy.request();
	proxy.handle();
	proxy.response();
    }
}
