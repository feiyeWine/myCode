package com.mediator;

public class Client {
    public static void main(String[] args) {
	Mediator m = new Manager();
	Department d = new Development(m);
	Market mar = new Market(m);
	Finacial f = new Finacial(m);
	
	d.selfAction();
	d.outAction();
    }
}
