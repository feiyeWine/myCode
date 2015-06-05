package com.state;

public class Client {
    public static void main(String[] args) {
	State s = new FreeState();
	State s2 = new BookedState();
	HomeContext c = new HomeContext();
	s.handle();
	c.setState(s2);
    }
}
