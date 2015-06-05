package cn.stringBulider;
/**
 * 模拟实现JDK中提供的ArrayList类
 * @author Administrator
 *
 */

public class MyArrayList {
	StringBuilder a;
	  /**
     * The value is used for character storage.
     */
    Object[] value;

    /**
     * The size is the number of characters used.
     */
    int size;
    public MyArrayList(){
    	value =new Object[16];
    }
    public MyArrayList(int size){
    	value =new Object[size];
    }
    public void add(Object obj){
    	value[size]=obj;
    	size++;
    }
	
}
