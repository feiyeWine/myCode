package cn.collection02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestEmployee02 {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("id", "001");
		map.put("name","高琪");
		map.put("salary",3500);
		map.put("date","2007-10");
		
		Map map2 = new HashMap();
		map2.put("id", "002");
		map2.put("name","马士兵");
		map2.put("salary",3600);
		map2.put("date","2006-10");
		
		Map map3 = new HashMap();
		map3.put("id", "003");
		map3.put("name","裴新");
		map3.put("salary",3500);
		map3.put("date","2006-10");
		
		List<Map> list = new ArrayList<Map>();
		list.add(map);
		list.add(map2);
		list.add(map3);
		for(int i = 0;i<list.size();i++)
		{
			System.out.println(list.get(i).get("name"));
			System.out.println(list.get(i).get("salary"));
		}
	}

}
