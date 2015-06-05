package com.FlyWeight;

public class Client {
    public static void main(String[] args) {
	ChessFlyWeight chess1 = FlyWeightFactory.getChess("黑色");
	ChessFlyWeight chess2 = FlyWeightFactory.getChess("黑色");
	System.out.println(chess1);
	System.out.println(chess2);
	System.out.println("外部————————");
	chess1.display(new Coordinate(10, 10));
	chess2.display(new Coordinate(20, 20));
    }
}
