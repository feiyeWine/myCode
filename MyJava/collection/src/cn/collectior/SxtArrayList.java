package cn.collectior;

import java.util.ArrayList;
import java.util.List;

/**
 * 自己实现一个ArrayList，帮助我们更好的理解ArrayList类的底层结构
 * 
 * @author Administrator
 *
 */

public class SxtArrayList {
	private Object[] elementData;
	private int size;
	
	public SxtArrayList(){
		this(10);
	}
	
	public SxtArrayList(int initlalCapacity){
		if(initlalCapacity<0){
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.elementData = new Object[initlalCapacity];
		
	}
	
	public boolean add(Object e) {
        elementData[size++] = e;
        return true;
    }
	
	 public void add(int index,Object element) {
	        rangeCheckForAdd(index);
	        if(index>=size)
	        System.arraycopy(elementData, index,elementData, index + 1,
	                         size - index);
	        elementData[index] = element;
	        size++;
	    }
	
	 private void rangeCheckForAdd(int index) {
	        if (index > size || index < 0)
	        	try {
					throw new Exception();
				} catch (Exception e) {
					e.printStackTrace();
				}
	    }
		
		public static void main(String[] args) {
			SxtArrayList list = new SxtArrayList();
			list.add("aaa");
			list.add("bbb");
			list.add(1, "ccc");
			System.out.println(list.size);
	}

}
