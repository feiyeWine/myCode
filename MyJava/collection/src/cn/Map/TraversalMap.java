package cn.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * ±éÀúMap
 * @author YR
 *
 */
public class TraversalMap {
    public static void main(String[] args) {
	Map<String,String> map = new HashMap<>();
	map.put("1", "hello");
	map.put("2", "hi");
	map.put("3", "bei");
	Set<Entry<String, String>> set = map.entrySet();
	Iterator<Entry<String, String>> iterator = set.iterator();
	while(iterator.hasNext()){
	    System.out.println(iterator.next());
	}
	
    }
}
