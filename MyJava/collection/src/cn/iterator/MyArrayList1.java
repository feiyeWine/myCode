package cn.iterator;

import java.util.Iterator;

public class MyArrayList1 {
	 String elem[] = {"a","b","c","d","e"};
	 int size = elem.length;
	 public class MyIt implements Iterator<String>{
		 int cursor = -1;
		 public boolean hasNext(){
			 return cursor+1<size;
		 }
		 public String next(){
			 cursor++;
			 return elem[cursor];
		 }
		 public void remove(){
			 while(hasNext()){
			 elem[cursor] = elem[++cursor];
			 }
			 cursor--;
			 
		 }
		 
	 }
	 public Iterator<String> iterator(){
			 return new MyIt();
		 }
		 
	 public static void main(String[] args) {
		MyArrayList1 list = new MyArrayList1();
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		it.remove();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
