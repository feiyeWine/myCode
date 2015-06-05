package com.thirdwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test3 {
   private static  Map<String,Integer> datas = new HashMap<String, Integer>();
    public static void main(String[] args) {
	
	datas.put("j1", 15);
	datas.put("j2", 8);
	datas.put("j3", 3);
	datas.put("j4", 10);
	Set<Entry<String,Integer>> set = datas.entrySet();
	Iterator<Entry<String, Integer>> iter = set.iterator();
	System.out.println("调度前：");
	while(iter.hasNext())
	    System.out.print(iter.next()+"\t");
	
	 ByValueComparator bvc = new ByValueComparator((HashMap<String, Integer>) datas);
         
	        /*//第一种方法
	        TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);
	        sorted_map.putAll(datas);
	         
	        for(String name : sorted_map.keySet()){
	            System.out.printf("%s -> %d\n", name, datas.get(name));
	        }*/
	 
	        //第二种方法
	        List<String> keys = new ArrayList<String>(datas.keySet());
	        Collections.sort(keys, bvc);
	        System.out.println("\n调度顺序为：");
	        for(String key : keys) {
	            System.out.printf("%s -> %d\n", key, datas.get(key));
	        }
	    }
	 
    }
class ByValueComparator implements Comparator<String> {
    HashMap<String, Integer> base_map;

    public ByValueComparator(HashMap<String, Integer> datas) {
        this.base_map = datas;
    }

    public int compare(String arg0, String arg1) {
        if (!base_map.containsKey(arg0) || !base_map.containsKey(arg1)) {
            return 0;
        }

        if (base_map.get(arg0) < base_map.get(arg1)) {
            return 1;
        } else if (base_map.get(arg0) == base_map.get(arg1)) {
            return 0;
        } else {
            return -1;
        }
    }
}
