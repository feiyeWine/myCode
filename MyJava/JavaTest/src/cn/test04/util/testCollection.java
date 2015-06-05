package cn.test04.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * ²âÊÔÈİÆ÷
 * @author YR
 *
 */
public class testCollection {
    public static void main(String[] args) {
	//test();
	test1();
    }
    //±éÀúmap µü´úÆ÷
    public static void test(){
	Map<String,Integer> map = new HashMap();
	for(int i = 0;i<10;i++){
	    map.put("key"+i, i);
	}
	Iterator it = map.entrySet().iterator();
	while(it.hasNext()){
	    Map.Entry entry = (Map.Entry)it.next();
	    Object key = entry.getKey();
	    Object value = entry.getValue();
	    System.out.println("key:"+key+"\tvalue:"+value);
	}
    }
    //±éÀúmap for
    public static void test1(){
	Map<String,Integer> map = new HashMap();
	for(int i = 0;i<10;i++){
	    map.put("key"+i, i);
	}
	for(String key:map.keySet()){
	    Integer value = (Integer)map.get(key);
	    System.out.println("key:"+key+"\tvalue:"+value);
	}
    }
}
