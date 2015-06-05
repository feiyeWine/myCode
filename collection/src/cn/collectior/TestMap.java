package cn.collectior;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("Mr Zhang",new Wife("Mrs Li"));
		map.put("Mr Hang",new Wife("Mrs Zhao"));
		Wife w = (Wife) map.get("Mr Zhang");
		map.remove("Mr Zhang");
		map.containsKey("Mr Hang");
		System.out.println(w.name);
	}

}
class Wife{
	String name;
	public Wife(String name){
		this.name = name;
	}
	
}