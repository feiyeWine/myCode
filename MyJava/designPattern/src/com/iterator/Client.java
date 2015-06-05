package com.iterator;

public class Client {
    public static void main(String[] args) {
	  ConcreteAddregate con = new ConcreteAddregate();
	  con.addObj("aa");
	  con.addObj("bb");
	  con.addObj("cc");
	  con.removeObj("bb");
	  
	  MyIterator iter = con.getIterator();
	  while(iter.hasNext()){
	      System.out.println(iter.getCursor());
	      iter.next();
	  }
    }
}
