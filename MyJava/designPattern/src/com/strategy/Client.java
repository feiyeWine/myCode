package com.strategy;

public class Client {
    public static void main(String[] args) {
	Strategy s = new OldMany();
	Strategy s2 = new NewMany();
	Context c = new Context(s);
	c.printPrice(1000);
	Context c2 = new Context(s2);
	c2.printPrice(1000);
    }
}
