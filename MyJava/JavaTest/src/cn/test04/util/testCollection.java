package cn.test04.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * ��������
 * @author YR
 *
 */
public class testCollection {
    public static void main(String[] args) {
	//test();
	test1();
    }
    //����map ������
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
    //����map for
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
