package com.brige;

public class Client {
    public static void main(String[] args) {
	Computer c = new Laptop(new Lenovo());
	c.sale();
    }
}
