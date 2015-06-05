package com.command;

public class Client {
    public static void main(String[] args) {
	Command c = new Concentrate(new Receiver());
	Invoke i = new Invoke(c);
	c.execute();
    }
}
